package com.presentation.andy.service;

import com.presentation.andy.loger.Loger;
import com.presentation.andy.model.Role;
import com.presentation.andy.model.Status;
import com.presentation.andy.model.Worker;
import com.presentation.andy.enums.Column;
import com.presentation.andy.enums.Projects;
import com.presentation.andy.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class WorkServiceImpl implements WorkerService {


    private final UserRepo userRepo;

    private static final Loger loger =new Loger();

    @Autowired
    public WorkServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<Worker> findAll() {
        return new ArrayList<>(userRepo.findAll());
    }

    @Override
    public boolean getResolution(){
        Optional<Worker> worker = userRepo.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        return worker.get().getRole().equals(Role.ADMIN) || worker.get().getRole().equals(Role.SUPERADMIN);
    }
    @Override
    public boolean getResolutionForAdd() {
        Optional<Worker> worker = userRepo.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        return worker.get().getRole().equals(Role.SUPERADMIN);
    }

    @Override
    public List<Worker> SortByNameCollum(String sort){
           try {
               if ((sort.replaceAll(" ", "").toLowerCase(Locale.ROOT)).equals(Column.имя.toString()))  return userRepo.findAll(Sort.by(Sort.Direction.ASC, "firstname"));
               if ((sort.replaceAll(" ", "").toLowerCase(Locale.ROOT)).equals(Column.выполненныезадачи.toString()))  return userRepo.findAll(Sort.by(Sort.Direction.DESC, "cdtasks"));
               if ((sort.replaceAll(" ", "").toLowerCase(Locale.ROOT)).equals(Column.невыполненныезадачи.toString()))  return userRepo.findAll(Sort.by(Sort.Direction.DESC, "outstandingtasks"));
               if ((sort.replaceAll(" ", "").toLowerCase(Locale.ROOT)).equals(Column.оплатавдень.toString()))  return userRepo.findAll(Sort.by(Sort.Direction.ASC, "salary"));
               if ((sort.replaceAll(" ", "").toLowerCase(Locale.ROOT)).equals(Column.проект.toString()))  return userRepo.findAll(Sort.by(Sort.Direction.ASC, "workprojects"));
               if ((sort.replaceAll(" ", "").toLowerCase(Locale.ROOT)).equals(Column.сейчасработает.toString()))  return userRepo.findAll(Sort.by(Sort.Direction.ASC, "online"));
           }
          catch (IllegalArgumentException e){
               loger.log("неверный агрумент для сортировки") ;
              return userRepo.findAll();
          }
           catch (NullPointerException e){
               loger.log("непредоставлен агрумент для сортировки") ;
        }
        return userRepo.findAll();
    }

    //String pw_hash = BCrypt.hashpw(root, BCrypt.gensalt(12));
    @Override
    public boolean add(Map<String, String> params) {
        try {
            if(isParamsValid(params) || isAllParamsFound(params)) {
                String email = params.getOrDefault("email", null);
                String pass = params.getOrDefault("pass", null);
                pass = BCrypt.hashpw(pass, BCrypt.gensalt(12));
                Integer salary = Integer.parseInt(params.getOrDefault("salary", null));
                String name = params.getOrDefault("name", null);
                String fname = params.getOrDefault("fname", null);
                Role role = Role.valueOf(params.get("role"));
                Status status = Status.valueOf(params.get("status"));
                Projects workProjects = Projects.valueOf(params.get("workProjects"));
                Boolean online = Boolean.parseBoolean(params.getOrDefault("online", "false"));
               // Worker worker = new Worker(email, pass, salary, name, fname, role, status, null, null, workProjects, online);
                userRepo.save(new Worker(email, pass, salary, name, fname, role, status, null, null, workProjects, online));
                return true;
            }
        } catch (NullPointerException | IllegalArgumentException | ClassCastException e) {
            loger.log("Новый работник не добавлен, ошибка присваивания параметров ! ");
            return false;
        }
        loger.log("Новый работник не добавлен, введены не все параметры или параметры не валидны ! ");
        return false;
    }

    @Override
    public boolean isAllParamsFound(Map<String, String> params) {
        return params.containsKey("email")
                && params.containsKey("pass")
                && params.containsKey("salary")
                && params.containsKey("name")
                && params.containsKey("fname")
                && params.containsKey("role")
                && params.containsKey("status")
                && params.containsKey("workProjects")
                && params.containsKey("online")
                ;
    }

    @Override
    public boolean isParamsValid(Map<String, String> params) {
        return validEmail(params.get("email")) &&
                validPass(params.get("pass")) &&
                validSalary(params.get("salary")) &&
                validName(params.get("name")) &&
                validFName(params.get("fname")) &&
                validRole(params.get("role")) &&
                validStatus(params.get("status")) &&
                validWorkProjects(params.get("workProjects")) &&
                validOnline(params.get("online"));
    }

    private boolean validEmail(String email) {
           return email != null &&
                   email.contains("@") &&
                   ( email.contains(".com") || email.contains(".ru"));
    }

    private boolean validPass(String pass) {
        return pass != null && pass.length()>3; //пока всё, это же тестовый проект!!!
    }
    private boolean validSalary(String salary) {
        try {
            int sal = Integer.parseInt(salary);
            return sal <= 10000 && sal >= 800;
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
    }

    private boolean validName(String name) {
        return name != null && name.length() <= 12 && name.length() > 0;
    }

    private boolean validFName(String fname) {
        return fname != null && fname.length() <= 50 && fname.length() > 0;
    }

    private boolean validRole(String role) {
         return role.equals("USER") || role.equals("ADMIN") || role.equals("SUPERADMIN") ;
    }
    private boolean validStatus(String status) {
        return status.equals("BANNED") || status.equals("ACTIVE") ;
    }

    private boolean validTasks(String tasks) {
        return tasks != null && tasks.length() <= 1000 && tasks.length() > 0;
    }

    private boolean validWorkProjects(String workProjects) {
        try {
            Projects.valueOf(workProjects);
            return true;
        } catch (IllegalArgumentException | NullPointerException e) {
            return false;
        }
    }
    private boolean validOnline(String online) {
        return online.equals("true") || online.equals("false") ;
    }


    @Override
    public boolean updateTasks(Map<String, String> params) {
        if (params == null || params.getOrDefault("id",null)==null) {
            loger.log("пустые параметры или не предоставлено ID");
            return false;
        }

        try {
            Worker result = userRepo.findById(Long.parseLong(params.get("id"))).get();
            String allTaskReady = params.getOrDefault("allTaskReady", "n");
            if (allTaskReady.equals("y")) {
                System.out.println("y");
                result.setCdtasks("");
            }
            String delTask = params.getOrDefault("delTask", null);
            String task = params.getOrDefault("task", null);
            if (validTasks(delTask) && result.getOutstandingtasks().contains(delTask)) {
                result.setOutstandingtasks(result.getOutstandingtasks().replaceAll(" Next: " + delTask, ""));
                result.setCdtasks(result.getCdtasks() + " " + "Next: " + delTask);
            }
            else loger.log("вы хотите убрать несуществующую задачу");

            if (validTasks(task))
                result.setOutstandingtasks(result.getOutstandingtasks() + " " + "Next: " + task);
            userRepo.save(result); //AndFlush
            loger.log("успешное редактирование задач пользователя "+result.getEmail());
            return true;
        } catch (NoSuchElementException | NullPointerException | NumberFormatException e) {
            loger.log("пользователь не найден или некорректно введён ID");
            return false;
        }
    }

    @Override
    public boolean updateEmployer(Map<String, String> params) {
        if (params == null || params.getOrDefault("id",null)==null) {
            loger.log("пустые параметры или не предоставлено ID");
            return false;
        }

        try {
            Worker result = userRepo.findById(Long.parseLong(params.get("id"))).get();
            String name = params.getOrDefault("name", result.getFirstname());
            int salary =  Integer.parseInt(params.getOrDefault("salary",result.getSalary().toString()));
            Projects workProject = Projects.valueOf(params.getOrDefault("workProject", result.getWorkprojects().toString()));
            if(validName(name) && validSalary(String.valueOf(salary))&& validWorkProjects(workProject.toString())){
                System.out.println(workProject.toString());
                result.setFirstname(name);
                result.setSalary(salary);
                result.setWorkprojects(workProject);
                userRepo.save(result); //AndFlush
                loger.log("успешное редактирование задач пользователя "+result.getEmail());
                return true;
            }
            return false;
        } catch (NoSuchElementException | NullPointerException | NumberFormatException e) {
            loger.log("пользователь не найден или некорректно введены параметры");
            return false;
        }
    }

    @Override
    public boolean deleteById(Long id) {
        boolean isExists = userRepo.existsById(id);
        if (isExists) {
            userRepo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Optional<Worker> findById(Long id) {
        return userRepo.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return userRepo.existsById(id);
    }

}


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
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class WorkServiceImpl implements WorkerService {


    private final UserRepo userRepo;

    private static Loger loger =new Loger();

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
        return worker.get().getRole().equals(Role.ADMIN);
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




    @Override
    public Worker add(Map<String, String> params) {
        try {
            String name = params.getOrDefault("name", null);
            String fname = params.getOrDefault("fname", null);
            String email = params.getOrDefault("email", null);
            String pass = params.getOrDefault("pass", null);
            String completedTasks = params.getOrDefault("completedTasks", null);
            String outstandingTasks = params.getOrDefault("outstandingTasks", null);
            Projects workProjects = Projects.valueOf(params.get("workProjects"));
            Role role = Role.valueOf(params.get("role"));
            Status status = Status.valueOf(params.get("status"));
            Boolean online = Boolean.parseBoolean(params.getOrDefault("online", "false"));
            Integer salary = Integer.parseInt(params.getOrDefault("salary", "800"));
            Worker worker = new Worker(email, pass, salary, name, fname, role, status, completedTasks, outstandingTasks, workProjects, online);
            return userRepo.save(worker);
        } catch (NullPointerException | IllegalArgumentException | ClassCastException e) {
            return null;
        }
    }

    @Override
    public boolean updatePlayer(Long id, Map<String, String> params) {
        if (params == null ) {
            System.out.println("пустые параметры");
            return false;

        }
        try {
            Worker result = userRepo.findById(id).get();
            String allTaskReady = params.getOrDefault("allTaskReady", "n");
            if (allTaskReady.equals("y")) {
                System.out.println("y");
                result.setCdtasks("");
            }
            String name = params.getOrDefault("name", null);
            String cdTasks = params.getOrDefault("cdTasks", null);
            String outstandingTasks = params.getOrDefault("outstandingTasks", null);
            try {
                Projects workProjects = params.containsKey("workProject") ? Projects.valueOf(params.get("workProject")) : null;
                if (workProjects != null) result.setWorkprojects(workProjects);
            } catch (IllegalArgumentException e) {
                System.out.println("в работе нет таких проектов перевод не возможен");
            }
            Boolean online = params.containsKey("online") ? "true".equals(params.get("online")) : null;
            try {
                Integer salary = Integer.parseInt(params.getOrDefault("salary", String.valueOf(result.getSalary())));
                result.setSalary(salary);
            } catch (NumberFormatException e) {
///Loger.log(неверно выставленно ЗП)
            }
            if (name != null && name.length() > 2 && name.length()<12) result.setFirstname(name);
            if (cdTasks != null && cdTasks.length() > 3 && result.getOutstandingtasks().contains(cdTasks)) {
                result.setOutstandingtasks(result.getOutstandingtasks().replaceAll(" Next: " + cdTasks, ""));
                result.setCdtasks(result.getCdtasks() + " " + "Next: " + cdTasks);
            }
            if (outstandingTasks != null && outstandingTasks.length() > 3)
                result.setOutstandingtasks(result.getOutstandingtasks() + " " + "Next: " + outstandingTasks);
            if (online != null) result.setOnline(online);

            userRepo.save(result); //AndFlush
            return true;
        } catch (NoSuchElementException e) {
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
    public Integer count() {
        try {
            return Math.toIntExact(userRepo.count());
        } catch (ArithmeticException e) {
            return Integer.MAX_VALUE;
        }
    }

    @Override
    public Worker findById(Long id) {
        return null;
    }

    @Override
    public boolean existsById(Long id) {
        return userRepo.existsById(id);
    }

    @Override
    public boolean isIdValid(Long id) {
        return (id > 0);
    }

    @Override
    public boolean isParamsValid(Map<String, String> params) {
        return validName(params.get("name")) &&
                validOutstandingTasks(params.get("outstandingTasks")) &&
                validCompletedTasks(params.get("completedTasks")) &&
                validWorkProjects(params.get("workProjects")) &&
                validSalary(params.get("salary"));
    }

    @Override
    public boolean validParamsForUpdate(Map<String, String> params) {
        boolean result = true;
        if (params.containsKey("name")) {
            result = validName(params.get("name"));
        }
        if (!result) {
            return false;
        }

        if (params.containsKey("completedTasks")) {
            result = validCompletedTasks(params.get("completedTasks"));
        }
        if (!result) {
            return false;
        }
        if (params.containsKey("outstandingTasks")) {
            result = validOutstandingTasks(params.get("outstandingTasks"));
        }
        if (!result) {
            return false;
        }

        if (params.containsKey("workProjects")) {
            result = validWorkProjects(params.get("workProjects"));
        }
        if (!result) {
            return false;
        }
        if (params.containsKey("salary")) {
            result = validSalary(params.get("salary"));
        }
        if (!result) {
            return false;
        }
        return true;
    }

    public boolean validName(String name) {
        return name != null && name.length() <= 12 && name.length() > 0;
    }

    public boolean validCompletedTasks(String title) {
        return title != null && title.length() <= 1000 && title.length() > 0;
    }

    public boolean validOutstandingTasks(String title) {
        return title != null && title.length() <= 1000 && title.length() > 0;
    }

    public boolean validSalary(String salary) {
        try {
            int sal = Integer.parseInt(salary);
            return sal <= 10000 && sal >= 0;
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
    }

    public boolean validWorkProjects(String workProjects) {
        try {
            Projects.valueOf(workProjects);
            return true;
        } catch (IllegalArgumentException | NullPointerException e) {
            return false;
        }
    }

    @Override
    public boolean isAllParamsFound(Map<String, String> params) {
        return params.containsKey("name")
                && params.containsKey("completedTasks")
                && params.containsKey("outstandingTasks")
                && params.containsKey("workProjects")
                && params.containsKey("salary")
                ;
    }
}


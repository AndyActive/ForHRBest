
package com.presentation.andy.service;

import com.presentation.andy.model.Worker;
import com.presentation.andy.projects.Projects;

import com.presentation.andy.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class WorkServiceImpl implements WorkerService{



       private final UserRepo userRepo;

    public WorkServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @Override
        public List<Worker> findAll(Pageable pageable) {
            return userRepo.findAll(pageable).stream().collect(Collectors.toList());
        }

        @Override
        public Worker add(Map<String, String> params) {
            try {
                String name = params.getOrDefault("name", null);
                String completedTasks = params.getOrDefault("completedTasks", null);
                String outstandingTasks = params.getOrDefault("outstandingTasks", null);
                Projects workProjects = Projects.valueOf(params.get("workProjects"));
                Boolean online = Boolean.parseBoolean(params.getOrDefault("online", "false"));
                Integer salary = Integer.parseInt(params.getOrDefault("salary","800"));
                Worker worker = new Worker(salary, name,completedTasks,outstandingTasks,workProjects,online);
                return userRepo.save(worker);
            } catch (NullPointerException | IllegalArgumentException | ClassCastException e) {
                return null;
            }
        }

        @Override
        public Worker updatePlayer(Long id, Map<String, String> params) {
            if (!userRepo.findById(id).isPresent() || params == null) return null;
            Worker result = userRepo.findById(id).get();
            String name = params.getOrDefault("name", null);
            String completedTasks = params.getOrDefault("completedTasks", null);
            String outstandingTasks = params.getOrDefault("outstandingTasks", null);
            Projects workProjects = params.containsKey("workProjects") ? Projects.valueOf(params.get("workProjects")) : null;
            Boolean online = params.containsKey("online") ? "true".equals(params.get("online")) : null;
            Integer salary =Integer.parseInt( params.getOrDefault("salary",String.valueOf(result.getSalary())) );
            if (name != null) result.setName(name);
            if (completedTasks != null) {
                result.setCompletedTasks(result.getCompletedTasks()+" "+completedTasks);
                result.setOutstandingTasks(result.getOutstandingTasks().replace(completedTasks,""));
            }
            result.setSalary(salary);
            if(outstandingTasks!=null) result.setOutstandingTasks(result.getOutstandingTasks()+" "+outstandingTasks);
            if (workProjects != null) result.setWorkProjects(workProjects);
            if (online != null) result.setOnline(online);

            userRepo.save(result); //AndFlush
            return result;
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
        public Worker findById(Long id) {
            return userRepo.findById(id).get();
        }


        @Override
        public List<Worker> findByParams(Map<String, String> params) {
            String name = (String) params.getOrDefault("name", null);
            String completedTasks = params.getOrDefault("completedTasks", null);
            String outstandingTasks = params.getOrDefault("outstandingTasks", null);
            Projects workProjects = params.containsKey("workProjects") ? Projects.valueOf((String) params.get("workProjects")) : null;
            Boolean online = params.containsKey("online") ? Boolean.parseBoolean(params.get("online")) : null;
            Integer salary =Integer.parseInt( params.getOrDefault("salary", "0"));
            return userRepo.findAllByParams( name ,salary, completedTasks,outstandingTasks,workProjects,online).stream().collect(Collectors.toList());

        }

        @Override
        public Integer countByParams(Map<String, String> params) {
            String name = (String) params.getOrDefault("name", null);
            String completedTasks = params.getOrDefault("completedTasks", null);
            String outstandingTasks = params.getOrDefault("outstandingTasks", null);
            Projects workProjects = params.containsKey("workProjects") ? Projects.valueOf((String) params.get("workProjects")) : null;
            Boolean online = params.containsKey("online") ? Boolean.parseBoolean(params.get("online")) : null;
            Integer salary =Integer.parseInt( params.getOrDefault("salary", "0"));
            return userRepo.countByParams(name,salary, completedTasks,outstandingTasks,workProjects,online);
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
                int exp = Integer.parseInt(salary);
                return exp<=10000 && exp >= 0;
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


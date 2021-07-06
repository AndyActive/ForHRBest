package com.presentation.andy.controllers;


import com.presentation.andy.model.Worker;
import com.presentation.andy.service.WorkerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


@Controller
public class HomeController {

    private final WorkerService workerService;

    @Autowired
    public HomeController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @GetMapping("")
    public String home(@RequestParam(value = "sort", required = false) String sort,
                       Model model) {
        model.addAttribute("title", "главный хому");

        model.addAttribute("users", workerService.findAll());
        return "index";

    }

    @GetMapping("/tasks")
    public String management(
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "task", required = false) String task,
            @RequestParam(value = "delTask", required = false) String dellTask,
            @RequestParam(value = "allTaskReady", required = false) String allTaskReady,

            Model model) {
        model.addAttribute("users", workerService.findAll());
        model.addAttribute("title", "управление задачами");
        Map<String,String> params = new HashMap<>();
        params.put("outstandingTasks",task);
        params.put("cdTasks",dellTask);
        params.put("allTaskReady",allTaskReady);
       if(id==null || !workerService.updatePlayer(id,params) )
        {
            return "tasks";
        }
        return "index";

    }

    @GetMapping("/workers")
    public String workers(
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "salary", required = false) String salary,
            @RequestParam(value = "workProject", required = false) String workProject,
            Model model) {
        model.addAttribute("users", workerService.findAll());
        model.addAttribute("title", "управление работниками");
        Map<String,String> params = new HashMap<>();
        params.put("name",name);
        params.put("salary",salary);
        params.put("workProject",workProject);
        if(id==null || !workerService.updatePlayer(id,params) )
        {
            return "workers";
        }
        return "index";
    }

}


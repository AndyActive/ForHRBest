package com.presentation.andy.controllers;


import com.presentation.andy.model.Worker;
import com.presentation.andy.service.WorkerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;


@Controller
public class HomeController {

    private final WorkerService workerService;

    @Autowired
    public HomeController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @GetMapping("")
    public String home(Model model) {
        ArrayList <Worker> test = (ArrayList<Worker>) workerService.findAll();
        System.out.println(test.get(0).getCdTasks());
        model.addAttribute("title", "главный хому");
        model.addAttribute("users", workerService.findAll());
        return "index";

    }

    @GetMapping("/tasks")
    public String management(Model model) {
        model.addAttribute(workerService.findAll());
        model.addAttribute("users", workerService.findAll());
        return "tasks";
    }

    @GetMapping("/workers")
    public String workers(Model model) {
        model.addAttribute(workerService.findAll());
        model.addAttribute("users", workerService.findAll());
        return "workers";
    }
}


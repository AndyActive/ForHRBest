package com.presentation.andy.controllers;




import com.presentation.andy.service.WorkerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {

    private final WorkerService workerService;

    @Autowired
    public HomeController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @GetMapping("/fare")
    public String home(Model model) {
        model.addAttribute(workerService.findAll());
        model.addAttribute("title", "главный хому");
        model.addAttribute("users", workerService.findAll());
        return "index";

    }

    @GetMapping("/management")
    public String management(Model model) {
        model.addAttribute(workerService.findAll());
        model.addAttribute("users", workerService.findAll());
        return "management";
    }
}


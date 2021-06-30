package com.presentation.andy.controllers;




import com.presentation.andy.service.WorkerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class HomeController {

    @Autowired
    private final WorkerService workerService;

    public HomeController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("title","главный хому");
return "index";
    }
}

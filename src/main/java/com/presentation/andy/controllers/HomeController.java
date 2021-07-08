package com.presentation.andy.controllers;


import com.presentation.andy.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@Controller
public class HomeController {

    private final WorkerService workerService;



    @Autowired
    public HomeController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @GetMapping("/login")
    public String getLoginPage() {

        return "login";
    }


    @GetMapping("/logout")
    public String getLogout() {
        return "login";
    }

    @GetMapping("")
    @PreAuthorize("hasAuthority('developers:read')")
    public String home(@RequestParam(value = "sort", required = false) String sort,
                       Model model) {
        model.addAttribute("title", "вы находитесь на вкладке Главная Страница");
        model.addAttribute("users", workerService.SortByNameCollum(sort));
        return "index";

    }

    @GetMapping("/tasks")
    @PreAuthorize("hasAuthority('developers:read')")
    public String management(
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "task", required = false) String task,
            @RequestParam(value = "delTask", required = false) String dellTask,
            @RequestParam(value = "allTaskReady", required = false) String allTaskReady,
            @RequestParam(value = "sort", required = false) String sort,
            Model model) {

        if (workerService.getResolution()) {
            model.addAttribute("users", workerService.SortByNameCollum(sort));
            model.addAttribute("title", "вы находитесь на вкладке Управление задачами");
            Map<String, String> params = new HashMap<>();
            params.put("outstandingTasks", task);
            params.put("cdTasks", dellTask);
            params.put("allTaskReady", allTaskReady);
            if (id == null || !workerService.updatePlayer(id, params)) {
                return "tasks";
            }
           return "redirect:/";
        }
        return "accessEror";

    }

    @GetMapping("/workers")
    @PreAuthorize("hasAuthority('developers:read')")
    public String workers(
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "salary", required = false) String salary,
            @RequestParam(value = "workProject", required = false) String workProject,
            @RequestParam(value = "sort", required = false) String sort,
            Model model) {
        if (workerService.getResolution()) {
            model.addAttribute("users", workerService.SortByNameCollum(sort));
            model.addAttribute("title", "вы находитесь на вкладке  управление работниками");
            Map<String, String> params = new HashMap<>();
            params.put("name", name);
            params.put("salary", salary);
            params.put("workProject", workProject);
            if (id == null || !workerService.updatePlayer(id, params)) {
                return "workers";
            }
            return "redirect:/";
        }
        return "accessEror";
    }

}


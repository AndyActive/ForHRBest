package com.presentation.andy.controllers;


import com.presentation.andy.model.Worker;
import com.presentation.andy.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    public String management( @RequestParam Map<String,String> Params, Model model) {
           if(workerService.getResolution()) {
               model.addAttribute("title", "вы находитесь на вкладке Управление задачами");
               if (!workerService.updateTasks(Params)) {
                   return "tasks";
               }
               return "redirect:/";
           }
        return "accessEror";
    }

    @GetMapping("/workers")
    @PreAuthorize("hasAuthority('developers:read')")
    public String workers( @RequestParam Map<String,String> Params, Model model) {
        if(workerService.getResolutionForAdd()) {
            model.addAttribute("title", "вы находитесь на вкладке Управление работниками");
            model.addAttribute("users" ,workerService.findAll());
            if (!workerService.updateEmployer(Params)) {
                return "workers";
            }
            return "redirect:/";
        }
        return "accessEror";
    }
    @GetMapping("/add")
    @PreAuthorize("hasAuthority('developers:read')")
    public String add( @RequestParam Map<String,String> Params, Model model) {
        if(workerService.getResolutionForAdd()) {
            model.addAttribute("title", "вы находитесь на вкладке добавления нового сотрудника");
            if (!workerService.add(Params)) {
                return "add";
            }
            return "redirect:/";
        }
        return "accessEror";
    }

    @PostMapping("/remove/{id}")
    public String delete(@PathVariable(value = "id") long id, Model model) {
        workerService.deleteById(id);
        return "redirect:/workers";
    }

}


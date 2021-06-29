package com.presentation.andy.controllers;

import com.presentation.andy.model.Worker;
import com.presentation.andy.repository.UserRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class HomeController {


    private UserRepo userRepo;

    @PostMapping
    public ResponseEntity addTask(@RequestBody Worker worker){
        try{
            userRepo.save(worker);
            return ResponseEntity.ok("Работник успешно добавлен");
        }
        catch (Exception e){
            return  ResponseEntity.badRequest().body("ошибка в методе AddTask (HomeController) ");
        }
    }



    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("title","главный хому");
return "home";
    }
}

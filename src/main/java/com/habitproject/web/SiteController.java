package com.habitproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SiteController {

    @GetMapping("/")
    public String HabitHomepage(){
        return "home";
    }

    @GetMapping("/dashboard")
    public String HabitDashboard(){
        return "dashboard";
    }

    @GetMapping("/clean")
    public String cleanSite(){
        return "clean";
    }
}
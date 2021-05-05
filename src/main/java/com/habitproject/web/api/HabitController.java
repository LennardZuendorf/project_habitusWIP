package com.habitproject.web.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HabitController {

    @GetMapping("/")
    public String HelloWorld(){
        return "HabitHome";
    }

}
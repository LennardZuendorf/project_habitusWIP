package com.habitproject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HabitController {

    @GetMapping("/")
    public String HelloWorld(){
        return "HelloWorld";
    }

}
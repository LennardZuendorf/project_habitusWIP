package com.habitproject.web;

import com.habitproject.configuration.Endpoints;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SiteController {

    @GetMapping("/")
    public String HabitHomepage(){
        return Endpoints.Site.INDEX;
    }

    @GetMapping("/home")
    public String HabitHomepage2(){
        return Endpoints.Site.INDEX;
    }

    @GetMapping("/dashboard")
    public String HabitDashboard(){
        return Endpoints.Site.DASH;
    }

    @GetMapping("/error")
    public String Error(){
        return Endpoints.Site.ERROR;
    }



    @GetMapping("/test")
    public String testSite(){
        return Endpoints.Site.TEST;
    }
}
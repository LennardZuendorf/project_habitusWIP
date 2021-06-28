package com.habitproject.web;

import com.habitproject.configuration.Endpoints;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SiteController {

    @RequestMapping(path = Endpoints.Site.SLASH)
    public ModelAndView showIndexPage() {
        return new ModelAndView("home.html");
    }

    @GetMapping(path = Endpoints.Site.INDEX)
    public ModelAndView showIndexPage2() {
        return new ModelAndView("home.html");
    }

    @GetMapping(path = Endpoints.Site.DASH)
    public ModelAndView showDashboard() {
        return new ModelAndView("dashboard.html");
    }

    @GetMapping(path = Endpoints.Site.ERROR)
    public ModelAndView showError() {
        return new ModelAndView("error.html");
    }

    @GetMapping(path = Endpoints.Site.LOGIN)
    public ModelAndView showLogin() {
        return new ModelAndView("login.html");
    }
}
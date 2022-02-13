package com.habitproject.web;

import com.habitproject.configuration.Endpoints;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SiteController {

    @RequestMapping(path = Endpoints.Site.SLASH)
    public ModelAndView showIndexPage(@AuthenticationPrincipal OidcUser principal) {
        return new ModelAndView(Endpoints.Site.INDEX);
    }

    @GetMapping(path = Endpoints.Site.INDEX)
    public ModelAndView showIndexPage2(@AuthenticationPrincipal OidcUser principal) {
        return new ModelAndView(Endpoints.Site.INDEX);
    }

    @GetMapping(path = Endpoints.Site.DASH)
    public ModelAndView showDashboard(@AuthenticationPrincipal OidcUser principal) {
        return new ModelAndView(Endpoints.Site.DASH);
    }

    @GetMapping(path = Endpoints.Site.ERROR)
    public ModelAndView showError(@AuthenticationPrincipal OidcUser principal) {
        return new ModelAndView(Endpoints.Site.ERROR);
    }

    /*
    @GetMapping(path = Endpoints.Site.LOGIN)
    public ModelAndView showLogin(@AuthenticationPrincipal OidcUser principal) {
        return new ModelAndView(Endpoints.Site.LOGIN);
    }

     */
}
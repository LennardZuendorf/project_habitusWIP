package com.habitproject.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserRESTController {

    @GetMapping("/user")
    @PreAuthorize("hasAuthority('SCOPE_profile')")
    public ResponseEntity<String> userDetails(@AuthenticationPrincipal User user) {
        return ResponseEntity.status(HttpStatus.OK).body(user.toString());
    }
}
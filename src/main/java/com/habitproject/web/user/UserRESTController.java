package com.habitproject.web.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class UserRESTController {

    @GetMapping("/user")
    ResponseEntity <Object> getUserId (@AuthenticationPrincipal OidcUser user) {
        return ResponseEntity.status(HttpStatus.OK).body(user.getAttributes().get("id"));
    }
}
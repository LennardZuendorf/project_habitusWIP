package com.habitproject.web.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
class UserRESTController {

    @GetMapping("/user")
    ResponseEntity <Map<String, Object>> getUserId (@AuthenticationPrincipal OidcUser user) {
        System.out.println(user.getAttributes().get("sub"));
        return ResponseEntity.status(HttpStatus.OK).body(user.getAttributes());
    }
}
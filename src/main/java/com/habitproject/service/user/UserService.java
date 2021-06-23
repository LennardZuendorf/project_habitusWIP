package com.habitproject.service.user;

import org.springframework.security.oauth2.core.oidc.user.OidcUser;

import java.util.Map;

public interface UserService {

    //UserAccountEntity services
    Map<String, Object> getUser(OidcUser uid);
}

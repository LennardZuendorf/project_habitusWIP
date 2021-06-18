package com.habitproject.service.user;

import org.springframework.security.oauth2.core.oidc.user.OidcUser;

import java.util.Map;

public class UserServiceImpl implements UserService{

    @Override
    public Map<String, Object> getUser(OidcUser user) {
        return user.getAttributes();
    }
}

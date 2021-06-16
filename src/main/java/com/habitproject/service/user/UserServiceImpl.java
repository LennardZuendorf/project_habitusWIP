package com.habitproject.service.user;

import com.habitproject.web.user.UserRequestModel;
import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;

import java.util.Map;

public class UserServiceImpl implements UserService{

    @Override
    public Map<String, Object> getUser(OidcUser user) {
        return user.getAttributes();
    }
}

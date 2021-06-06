package com.habitproject.service.user;

import com.habitproject.web.user.UserRequestModel;
import org.springframework.http.HttpStatus;

public interface UserService {

    //UserAccountEntity services
    String postUser(UserRequestModel requestBody);
    String getUser(Long uid);
    HttpStatus putUser(Long uid, UserRequestModel requestBody);
    HttpStatus deleteUser(Long uid);


}

package com.habitproject.service.user;

import com.habitproject.web.user.UserRequestModel;
import org.springframework.http.HttpStatus;

public interface UserService {

    //UserAccountEntity services
    HttpStatus postUser(UserRequestModel requestBody);
    HttpStatus putUser(Long uid, UserRequestModel requestBody);
    HttpStatus deleteUser(Long uid);


}

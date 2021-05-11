package com.habitproject.service.user;

import com.habitproject.web.user.UserRequestModel;
import com.habitproject.web.user.UserStatusReturn;
import org.springframework.http.HttpStatus;

public interface UserService {

    //UserAccountEntity services
    UserStatusReturn postUser(UserRequestModel requestBody);
    UserStatusReturn getUser(Long uid);
    HttpStatus putUser(Long uid, UserRequestModel requestBody);
    HttpStatus deleteUser(Long uid);


}

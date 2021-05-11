package com.habitproject.service.user;

import com.habitproject.persistence.goal.GoalEntity;
import com.habitproject.web.EntityStatusReturns.HabitListStatusReturn;
import com.habitproject.web.EntityStatusReturns.HabitStatusReturn;
import com.habitproject.web.goal.GoalRequestModel;
import com.habitproject.web.habit.HabitRequestModel;
import com.habitproject.web.user.UserRequestModel;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface UserService {

    //UserAccountEntity services
    HttpStatus postUser(UserRequestModel requestBody);
    HttpStatus putUser(Long uid, UserRequestModel requestBody);
    HttpStatus deleteUser(Long uid);


}

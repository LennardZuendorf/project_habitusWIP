package com.habitproject.service;

import com.habitproject.persistence.goal.GoalEntity;
import com.habitproject.web.EntityStatusReturns.HabitListStatusReturn;
import com.habitproject.web.EntityStatusReturns.HabitStatusReturn;
import com.habitproject.web.goal.GoalRequestModel;
import com.habitproject.web.habit.HabitRequestModel;
import com.habitproject.web.user.UserRequestModel;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface AppService {

    //HabitEntity services
    HabitStatusReturn postHabit(HabitRequestModel requestBody);
    HabitStatusReturn getHabit(Long hid);
    HabitListStatusReturn getAllHabit(Long uid);
    HttpStatus putHabit(Long hid, HabitRequestModel requestBody);
    HttpStatus deleteHabit(Long hid);

    //GoalEntity services
    HttpStatus postGoal(GoalRequestModel requestBody);
    GoalEntity getGoal(Long gid);
    List<GoalEntity> getAllGoal(Long uid);
    HttpStatus putGoal(Long gid, GoalRequestModel requestBody);
    HttpStatus deleteGoal(Long gid);

    //UserAccountEntity services
    HttpStatus postUser(UserRequestModel requestBody);
    HttpStatus putUser(Long uid, UserRequestModel requestBody);
    HttpStatus deleteUser(Long uid);


}

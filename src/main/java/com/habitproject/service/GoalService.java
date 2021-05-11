package com.habitproject.service;

import com.habitproject.persistence.goal.GoalEntity;
import com.habitproject.web.goal.GoalRequestModel;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface GoalService {

    //GoalEntity services
    HttpStatus postGoal(GoalRequestModel requestBody);
    GoalEntity getGoal(Long gid);
    List<GoalEntity> getAllGoal(Long uid);
    HttpStatus putGoal(Long gid, GoalRequestModel requestBody);
    HttpStatus deleteGoal(Long gid);

}

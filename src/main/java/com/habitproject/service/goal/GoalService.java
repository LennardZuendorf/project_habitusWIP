package com.habitproject.service.goal;

import com.habitproject.web.goal.GoalListStatusReturn;
import com.habitproject.web.goal.GoalRequestModel;
import com.habitproject.web.goal.GoalStatusReturn;
import org.springframework.http.HttpStatus;

public interface GoalService {

    //GoalEntity services
    GoalStatusReturn postGoal(GoalRequestModel requestBody);
    GoalStatusReturn getGoal(Long gid);
    GoalListStatusReturn getAllGoal(Long uid);
    HttpStatus putGoal(Long gid, GoalRequestModel requestBody);
    HttpStatus deleteGoal(Long gid);

}

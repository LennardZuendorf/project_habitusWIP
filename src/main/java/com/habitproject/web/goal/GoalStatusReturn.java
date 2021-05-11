package com.habitproject.web.goal;

import com.habitproject.persistence.goal.GoalEntity;
import org.springframework.http.HttpStatus;

public class GoalStatusReturn {

    GoalEntity response;
    HttpStatus status;

    public GoalStatusReturn(GoalEntity response, HttpStatus status){
        this.response = response;
        this.status = status;
    }

    public GoalEntity getResponse() {
        return response;
    }
    public void setResponse(GoalEntity response) {
        this.response = response;
    }
    public HttpStatus getStatus() {
        return status;
    }
    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}

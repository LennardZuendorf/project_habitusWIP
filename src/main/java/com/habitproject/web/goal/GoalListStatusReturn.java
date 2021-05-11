package com.habitproject.web.goal;

import com.habitproject.persistence.goal.GoalEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

public class GoalListStatusReturn {

    List<GoalEntity> response;
    HttpStatus status;

    public GoalListStatusReturn(List<GoalEntity> response, HttpStatus status){
        this.response = response;
        this.status = status;
    }

    public List <GoalEntity> getResponse() {
        return response;
    }
    public void setResponse(List <GoalEntity> response) {
        this.response = response;
    }
    public HttpStatus getStatus() {
        return status;
    }
    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
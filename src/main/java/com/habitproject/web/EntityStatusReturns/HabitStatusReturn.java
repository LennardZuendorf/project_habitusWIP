package com.habitproject.web.EntityStatusReturns;

import com.habitproject.persistence.habit.HabitEntity;
import org.springframework.http.HttpStatus;

public class HabitStatusReturn  {

    HabitEntity response;
    HttpStatus status;

    public HabitStatusReturn(HabitEntity response, HttpStatus status){
        this.response = response;
        this.status = status;
    }

    public HabitEntity getResponse() {
        return response;
    }
    public void setResponse(HabitEntity response) {
        this.response = response;
    }
    public HttpStatus getStatus() {
        return status;
    }
    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}





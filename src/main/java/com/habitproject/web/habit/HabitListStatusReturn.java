package com.habitproject.web.habit;

import com.habitproject.persistence.habit.HabitEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

public class HabitListStatusReturn {

    List <HabitEntity> response;
    HttpStatus status;

    public HabitListStatusReturn(List <HabitEntity> response, HttpStatus status){
        this.response = response;
        this.status = status;
    }

    public List <HabitEntity> getResponse() {
        return response;
    }
    public void setResponse(List <HabitEntity> response) {
        this.response = response;
    }
    public HttpStatus getStatus() {
        return status;
    }
    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}


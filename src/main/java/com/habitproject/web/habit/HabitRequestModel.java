package com.habitproject.web.habit;

import com.habitproject.persistence.habit.HabitFrequency;

import java.time.LocalDateTime;

public class HabitRequestModel {

    private String tag;
    private HabitFrequency frequency;
    private Integer quantity;
    private String uid;
    private LocalDateTime lastCheck;
    private boolean done;
    private Integer doneAmount;

    public String getTag() {
        return tag;
    }
    public HabitFrequency getFrequency() {
        return frequency;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public String getUid() {
        return uid;
    }
    public LocalDateTime getLastCheck(){return lastCheck;}
    public boolean isDone() {
        return done;
    }
    public Integer getDoneAmount() {
        return doneAmount;
    }
}

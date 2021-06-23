package com.habitproject.web.habit;

import com.habitproject.persistence.habit.HabitFrequency;

import java.time.LocalDateTime;

public class HabitRequestModel {

    private String tag;
    private HabitFrequency frequency;
    private Integer quantity;
    private String uid;
    private LocalDateTime lastCheck;

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
}

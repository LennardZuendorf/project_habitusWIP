package com.habitproject.web.api;

import com.habitproject.persistence.HabitQuantity;

public class HabitRequestModel {

    private String tag;
    private HabitQuantity quantity;
    private Integer frequency;
    private Long user_id;

    public String getTag() {
        return tag;
    }
    public HabitQuantity getQuantity() {
        return quantity;
    }
    public Integer getFrequency() {
        return frequency;
    }
    public Long getUser_id() {
        return user_id;
    }
}

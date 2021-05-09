package com.habitproject.web.api;

import com.habitproject.persistence.HabitFrequency;

public class HabitRequestModel {

    private String tag;
    private HabitFrequency frequency;
    private Integer quantity;
    private Long uid;

    public String getTag() {
        return tag;
    }
    public HabitFrequency getFrequency() {
        return frequency;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public Long getUid() {
        return uid;
    }
}

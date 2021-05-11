package com.habitproject.web.api;

import com.habitproject.persistence.HabitFrequency;
import com.habitproject.persistence.UserAccountEntity;

public class HabitRequestModel {

    private String tag;
    private HabitFrequency frequency;
    private Integer quantity;
    private UserAccountEntity uid;

    public String getTag() {
        return tag;
    }
    public HabitFrequency getFrequency() {
        return frequency;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public UserAccountEntity getUid() {
        return uid;
    }
}

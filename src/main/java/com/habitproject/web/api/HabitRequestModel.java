package com.habitproject.web.api;

import com.habitproject.persistence.HabitQuantity;

public class HabitRequestModel {

    private String tag;
    private HabitQuantity quantity;
    private Integer frequency;

    public String getTag() {
        return tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }
    public HabitQuantity getQuantity() {
        return quantity;
    }
    public void setQuantity(HabitQuantity quantity) {
        this.quantity = quantity;
    }
    public Integer getFrequency() {
        return frequency;
    }
    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }
}

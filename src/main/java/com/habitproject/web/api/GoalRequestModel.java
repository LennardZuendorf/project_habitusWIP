package com.habitproject.web.api;

import com.habitproject.persistence.HabitFrequency;
import com.habitproject.persistence.UserAccountEntity;

import java.math.BigDecimal;

public class GoalRequestModel {

    private String tag;
    private String measure;
    private BigDecimal currentAmount;
    private BigDecimal totalAmount;
    private UserAccountEntity uid;

    public String getTag() {
        return tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }
    public String getMeasure() {
        return measure;
    }
    public void setMeasure(String measure) {
        this.measure = measure;
    }
    public BigDecimal getCurrentAmount() {
        return currentAmount;
    }
    public void setCurrentAmount(BigDecimal currentAmount) {
        this.currentAmount = currentAmount;
    }
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
    public UserAccountEntity getUid() {
        return uid;
    }
}


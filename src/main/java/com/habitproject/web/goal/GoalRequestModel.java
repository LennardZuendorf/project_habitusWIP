package com.habitproject.web.goal;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class GoalRequestModel {

    private String tag;
    private String measure;
    private BigDecimal currentAmount;
    private BigDecimal totalAmount;
    private Long uid;
    private LocalDateTime lastCheck;

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
    public Long getUid() {
        return uid;
    }
    public void setUid(Long uid) {
        this.uid = uid;
    }
    public LocalDateTime getLastCheck() {
        return lastCheck;
    }
    public void setLastCheck(LocalDateTime lastCheck) {
        this.lastCheck = lastCheck;
    }
}


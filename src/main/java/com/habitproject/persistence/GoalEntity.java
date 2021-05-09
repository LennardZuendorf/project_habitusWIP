package com.habitproject.persistence;

import java.math.BigDecimal;

public class GoalEntity {

    private final String id;
    private String desc;
    private String tag;

    private String quantity;
    private BigDecimal currentAmount;
    private BigDecimal totalAmount;


    public GoalEntity (String id, String desc, String tag, String quantity, BigDecimal currentAmount, BigDecimal totalAmount) {
        this.id = id;
        this.desc = desc;
        this.tag = tag;
        this.quantity = quantity;
        this.currentAmount = currentAmount;
        this.totalAmount = totalAmount;

    }

    public BigDecimal getPerc(){
        BigDecimal output = currentAmount;
        return output.divide(totalAmount).multiply(new BigDecimal(100));
    }

    public String getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
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

}

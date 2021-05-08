package com.habitproject.persistence;

import java.math.BigDecimal;

public class GoalEntity {

    private final String id;
    private final String desc;
    private final String tag;

    private final String quantity;
    private final String currentAmount;
    private final String totalAmount;


    public GoalEntity (String id, String desc, String tag, String quantity, String currentAmount, String totalAmount) {
        this.id = id;
        this.desc = desc;
        this.tag = tag;
        this.quantity = quantity;
        this.currentAmount = currentAmount;
        this.totalAmount = totalAmount;

    }
}

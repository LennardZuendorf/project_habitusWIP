package com.habitproject.persistence;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * GoalEntity defines database entries for persistence of goals. This is not used (yet).
 */

@Entity
@Table(name="goal")
public class GoalEntity {

    //variables and columns
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long gid;

    @Column
    private String tag;

    @Column
    private String quantity;

    @Column(name="current_amount")
    private BigDecimal currentAmount;

    @Column(name="total_amount")
    private BigDecimal totalAmount;

    //constructor
    public GoalEntity(String tag, String quantity, BigDecimal currentAmount, BigDecimal totalAmount) {
        this.tag = tag;
        this.quantity = quantity;
        this.currentAmount = currentAmount;
        this.totalAmount = totalAmount;
    }
    protected GoalEntity() {

    }

    //getter and setter
    public Long getGid() {
        return gid;
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
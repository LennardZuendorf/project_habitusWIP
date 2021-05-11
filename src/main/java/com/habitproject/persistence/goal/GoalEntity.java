package com.habitproject.persistence.goal;

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

    @Column(nullable = false)
    private String tag;

    @Column(nullable = false)
    private String measure;

    @Column(name="current_amount")
    private BigDecimal currentAmount;

    @Column(name="total_amount", nullable = false)
    private BigDecimal totalAmount;

    @Column(nullable = false)
    private Long uid;

    //constructor
    public GoalEntity(String tag, String measure, BigDecimal currentAmount, BigDecimal totalAmount, Long uid) {
        this.tag = tag;
        this.measure = measure;
        this.currentAmount = currentAmount;
        this.totalAmount = totalAmount;
        this.uid = uid;
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
}
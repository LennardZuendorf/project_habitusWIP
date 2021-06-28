package com.habitproject.persistence.habit;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * HabitEntity defines database entries for persistence
 */
@Entity
@Table(name = "habit")
public class HabitEntity {

    //variables and columns
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long hid;

    @Column(nullable = false)
    private String uid;

    @Column(nullable = false)
    private String tag;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private HabitFrequency frequency;

    @Column(nullable = false)
    private Integer quantity;

    @Column(name="last_check", nullable = true)
    private LocalDateTime lastCheck;

    @Column(nullable = false)
    private boolean done;

    @Column(name="done_amount")
    private Integer doneAmount;


    //constructor
    public HabitEntity(String uid, String tag, HabitFrequency frequency, Integer quantity, boolean done, Integer doneAmount ){
        this.uid = uid;
        this.tag = tag;
        this.frequency = frequency;
        this.quantity = quantity;
        this.lastCheck = lastCheck;
        this.done = done;
        this.doneAmount = doneAmount;
    }
    protected HabitEntity(){}

    //getter and setter
    public Long getHid() {
        return hid;
    }
    public String getTag() {
        return tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public HabitFrequency getFrequency() {
        return frequency;
    }
    public void setFrequency(HabitFrequency frequency) {
        this.frequency = frequency;
    }
    public String getUid() {
        return uid;
    }
    public LocalDateTime getLastCheck() {
        return lastCheck;
    }
    public void setLastCheck(LocalDateTime lastCheck) {
        this.lastCheck = lastCheck;
    }
    public boolean isDone() {
        return done;
    }
    public void setDone(boolean done) {
        this.done = done;
    }
    public Integer getDoneAmount() {
        return doneAmount;
    }
    public void setDoneAmount(Integer doneAmount) {
        this.doneAmount = doneAmount;
    }
}

package com.habitproject.persistence.habit;

import javax.persistence.*;

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

    @Column
    private String tag;

    @Column
    @Enumerated(value = EnumType.STRING)
    private HabitFrequency frequency;

    @Column
    private Integer quantity;

    @Column
    private Long uid;

    //constructor
    public HabitEntity(String tag, HabitFrequency frequency, Integer quantity, Long uid){
        this.tag = tag;
        this.frequency = frequency;
        this.quantity = quantity;
        this.uid = uid;
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
    public Long getUid() {
        return uid;
    }
}

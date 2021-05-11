package com.habitproject.persistence;

import javax.persistence.*;
import java.rmi.server.UID;

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

    @Column(nullable=false)
    private String tag;

    @Column(nullable=false)
    @Enumerated(value = EnumType.STRING)
    private HabitFrequency frequency;

    @Column(nullable=false)
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name="uid", nullable=false)
    private UserAccountEntity userAccountEntity;

    //constructor
    public HabitEntity(String tag, HabitFrequency frequency, Integer quantity, UserAccountEntity uid){
        this.tag = tag;
        this.frequency = frequency;
        this.quantity = quantity;
        this.userAccountEntity = uid;
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
    public UserAccountEntity getUid() {
        return userAccountEntity;
    }
}

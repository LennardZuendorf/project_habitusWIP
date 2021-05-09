package com.habitproject.persistence;

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
    private Long id;

    @Column(name = "tag")
    private String tag;

    @Column(name= "frequency")
    @Enumerated(value = EnumType.STRING)
    private HabitFrequency frequency;

    @Column(name= "quantity")
    private Integer quantity;

    @Column(name= "user_id_fk")
    private Long userId;

    //constructor
    public HabitEntity(String tag, HabitFrequency frequency, Integer quantity, Long userId){
        this.tag = tag;
        this.quantity = quantity;
        this.frequency = frequency;
        this.userId = userId;
    }
    protected HabitEntity(){}

    //getter and setter
    public Long getId() {
        return id;
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


}

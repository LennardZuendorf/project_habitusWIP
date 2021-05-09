package com.habitproject.persistence;

import javax.persistence.*;

@Entity
@Table(name = "habit")
public class HabitEntity {

    //variables and columns
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "tag")
    private String tag;

    @Column(name= "quantity")
    @Enumerated(value = EnumType.STRING)
    private HabitQuantity quantity;

    @Column(name= "frequency")
    private Integer frequency;

    @Column(name= "user_id_fk")
    private Long userId;

    //constructor
    public HabitEntity(String tag, HabitQuantity quantity, Integer frequency, Long userId){
        this.frequency = frequency;
        this.quantity = quantity;
        this.tag = tag;

        //always the same for testing purposes
        this.userId = userId;
        this.userId = 12345678910L;
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

    public HabitQuantity getQuantity() {
        return quantity;
    }

    public void setQuantity(HabitQuantity quantity) {
        this.quantity = quantity;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }
}

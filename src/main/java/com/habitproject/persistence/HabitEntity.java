package com.habitproject.persistence;

public class HabitEntity {

    private final String id;
    private final String desc;
    private final String tag;
    private final String frequency;


    public HabitEntity(String id, String desc,String tag, String frequency){
        this.id = id;
        this.desc = desc;
        this.frequency = frequency;
        this.tag = tag;
    }

}

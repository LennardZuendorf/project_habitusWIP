package com.habitproject.service;

import com.habitproject.persistence.HabitEntity;

import java.util.List;
import java.util.TreeSet;

public interface AppService {

    HabitEntity putHabit();
    HabitEntity getHabit();
    List<HabitEntity> getAllHabit();
    HabitEntity updateHabit();
    HabitEntity deleteHabit();

}

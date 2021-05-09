package com.habitproject.service;

import com.habitproject.persistence.HabitEntity;
import com.habitproject.persistence.HabitQuantity;

import java.util.List;

public interface AppService {

    HabitEntity putHabit(String tag, HabitQuantity quantity, Integer frequency, Long userId);
    HabitEntity getHabit(Long id);
    List<HabitEntity> getAllHabit(Long UserId);
    HabitEntity updateHabit(Long id, String tag, HabitQuantity quantity, Integer frequency);
    HabitEntity deleteHabit(Long id);

}

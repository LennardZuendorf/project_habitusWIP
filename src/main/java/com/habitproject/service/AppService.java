package com.habitproject.service;

import com.habitproject.persistence.HabitEntity;
import com.habitproject.web.api.HabitParamRequest;

import java.util.List;

public interface AppService {

    HabitEntity postHabit(HabitParamRequest requestBody);
    HabitEntity getHabit(Long id);
    List<HabitEntity> getAllHabit(Long UserId);
    HabitEntity putHabit(Long id, HabitParamRequest requestBody);
    HabitEntity deleteHabit(Long id);

}

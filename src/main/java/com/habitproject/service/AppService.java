package com.habitproject.service;

import com.habitproject.persistence.HabitEntity;
import com.habitproject.persistence.HabitQuantity;
import com.habitproject.web.api.HabitRequestModel;

import java.util.List;

public interface AppService {

    HabitEntity putHabit(HabitRequestModel requestBody);
    HabitEntity getHabit(Long id);
    List<HabitEntity> getAllHabit(Long UserId);
    HabitEntity patchHabit(Long id, HabitRequestModel requestBody);
    HabitEntity deleteHabit(Long id);

}

package com.habitproject.service;

import com.habitproject.persistence.HabitEntity;
import com.habitproject.web.api.HabitRequestModel;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface AppService {

    HabitEntity postHabit(HabitRequestModel requestBody);
    HabitEntity getHabit(Long id);
    List<HabitEntity> getAllHabit(Long UserId);
    HabitEntity putHabit(Long id, HabitRequestModel requestBody);
    HttpStatus deleteHabit(Long id);

}

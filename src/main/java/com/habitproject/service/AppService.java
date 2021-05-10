package com.habitproject.service;

import com.habitproject.persistence.HabitEntity;
import com.habitproject.web.api.HabitRequestModel;
import com.habitproject.web.api.UserRequestModel;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface AppService {

    HabitEntity postHabit(HabitRequestModel requestBody);
    HabitEntity getHabit(Long hid);
    List<HabitEntity> getAllHabit(Long uid);
    HttpStatus putHabit(Long hid, HabitRequestModel requestBody);
    HttpStatus deleteHabit(Long hid);

    HttpStatus postUser(UserRequestModel requestBody);
    HttpStatus putUser(Long uid, UserRequestModel requestBody);
    HttpStatus deleteUser(Long uid);

}

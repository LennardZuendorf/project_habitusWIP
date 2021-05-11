package com.habitproject.service;

import com.habitproject.web.EntityStatusReturns.HabitListStatusReturn;
import com.habitproject.web.EntityStatusReturns.HabitStatusReturn;
import com.habitproject.web.habit.HabitRequestModel;
import org.springframework.http.HttpStatus;

public interface HabitService {

    //HabitEntity services
    HabitStatusReturn postHabit(HabitRequestModel requestBody);
    HabitStatusReturn getHabit(Long hid);
    HabitListStatusReturn getAllHabit(Long uid);
    HttpStatus putHabit(Long hid, HabitRequestModel requestBody);
    HttpStatus deleteHabit(Long hid);
}

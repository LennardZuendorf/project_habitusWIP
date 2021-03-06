package com.habitproject.service.habit;

import com.habitproject.web.habit.HabitListStatusReturn;
import com.habitproject.web.habit.HabitStatusReturn;
import com.habitproject.web.habit.HabitRequestModel;
import org.springframework.http.HttpStatus;

public interface HabitService {

    //HabitEntity services
    HabitStatusReturn postHabit(HabitRequestModel requestBody);
    HabitListStatusReturn getHabits(String uid);
    HttpStatus putHabit(Long hid, HabitRequestModel requestBody);
    HttpStatus deleteHabit(Long hid);
    HttpStatus deleteAllHabits(String uid);
    void updateHabitsStatus(String uid);
}

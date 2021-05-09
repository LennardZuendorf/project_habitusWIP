package com.habitproject.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HabitRepository extends JpaRepository<HabitEntity, Long> {

    List<HabitEntity> findAllByUid(Long uid);
    HabitEntity findFirstByHid(Long hid);

    @Modifying
    @Query("update HabitEntity h set h.tag=?2, h.frequency=?3, h.quantity =?4 where h.hid=?1")
    void updateHabitByHid(@Param(value= "hid") long hid, @Param(value="tag")String tag, @Param(value="frequency") HabitFrequency frequency, @Param(value="quantity")Integer quantity);
}

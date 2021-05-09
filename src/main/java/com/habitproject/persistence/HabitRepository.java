package com.habitproject.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HabitRepository extends JpaRepository<HabitEntity, Long> {

    List<HabitEntity> findAllByUserId(Long userId);
    HabitEntity findFirstById(Long habitId);

    @Modifying
    @Query("update HabitEntity h set h.tag=?2, h.quantity=?3, h.frequency =?4 where h.id=?1")
    void updateHabitByID(@Param(value= "id") long id, @Param(value="tag")String tag, @Param(value="quantity")HabitQuantity quantity, @Param(value="frequency")Integer frequency);
}

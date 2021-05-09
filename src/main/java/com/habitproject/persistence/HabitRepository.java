package com.habitproject.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HabitRepository extends JpaRepository<HabitEntity, Long> {

    List<HabitEntity> findAllByUserId(Long userId);

    @Modifying
    @Query("update HabitEntity h set h.frequency =?2, h.quantity=?3, h.tag=?4 where h.id=?1")
    void updateHabitByID(Long id, String tag, HabitQuantity quantity, Integer frequency);
}

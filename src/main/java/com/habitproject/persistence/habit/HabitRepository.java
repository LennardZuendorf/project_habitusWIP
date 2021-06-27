package com.habitproject.persistence.habit;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HabitRepository extends JpaRepository<HabitEntity, Long> {
    List<HabitEntity> findAllByUid(String uid);
    HabitEntity findFirstByHid(Long hid);
    Boolean existsByUid(String uid);
}

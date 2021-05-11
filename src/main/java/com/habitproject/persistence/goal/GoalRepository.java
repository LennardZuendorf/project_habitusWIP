package com.habitproject.persistence.goal;

import com.habitproject.persistence.habit.HabitEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoalRepository extends JpaRepository<GoalEntity, Long> {
    List<GoalEntity> findAllByUid(Long uid);
    GoalEntity findFirstByGid(Long gid);
    Boolean existsByUid(Long uid);
}
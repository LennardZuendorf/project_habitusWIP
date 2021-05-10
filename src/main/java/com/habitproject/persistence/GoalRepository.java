package com.habitproject.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface GoalRepository extends JpaRepository<GoalEntity, Long> {
    List<GoalEntity> findAllByUid(Long uid);
    GoalEntity findFirstByGid(Long gid);
}

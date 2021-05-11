package com.habitproject.persistence.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserAccountEntity, Long> {
    UserAccountEntity findFirstByUid(Long uid);
}

package com.hasagawataiga.repository;

import com.hasagawataiga.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findOneByUserNameAndStatus(String username, int status);
}

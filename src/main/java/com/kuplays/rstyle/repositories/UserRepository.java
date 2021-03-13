package com.kuplays.rstyle.repositories;

import com.kuplays.rstyle.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Query("SELECT user FROM UserEntity user WHERE user.userName = ?1")
    UserEntity findByName(String userName);
}

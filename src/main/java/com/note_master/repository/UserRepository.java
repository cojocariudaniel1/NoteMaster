package com.note_master.repository;

import com.note_master.entity.UserEntity;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;

@EntityScan
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUsername(String username);

    UserEntity findUserEntityById(Integer id);

    UserEntity findByEmail(String email);
}

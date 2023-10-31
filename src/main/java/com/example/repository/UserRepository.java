package com.example.repository;

import com.example.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    // Metode personalizate pentru a efectua operații specifice
    UserEntity findByUsername(String username);

    UserEntity findUserEntityById(Integer id);

    UserEntity findByEmail(String email);
}

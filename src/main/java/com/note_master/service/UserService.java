package com.note_master.service;


import com.note_master.entity.NoteEntity;
import com.note_master.entity.UserEntity;
import com.note_master.repository.NoteRepository;
import com.note_master.repository.UserRepository;
import org.h2.engine.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository) {this.userRepository = userRepository;}

    public List<UserEntity> getAllUsers() {return userRepository.findAll();}

    public UserEntity getUserById(int id) {return userRepository.findById((long) id).orElse(null);}

    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);

    }

}

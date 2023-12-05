package com.note_master.repository;

import com.note_master.entity.Note;
import com.note_master.entity.Utilizator;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@EntityScan
public interface UtilizatorRepository extends JpaRepository<Utilizator, Long> {

    Utilizator findByUsername(String username);

    Utilizator findUserEntityById(Integer id);

    Utilizator findByEmail(String email);

}
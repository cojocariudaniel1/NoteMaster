package com.example.repository;

import com.example.entity.NoteEntity;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

@EntityScan
public interface NoteRepository extends JpaRepository<NoteEntity, Long> {

    // Metode personalizate pentru a efectua operații specifice
    List<NoteEntity> findByUserId(Integer userId);


    // Alte metode specifice pot fi adăugate pentru căutări după alt criteriu

    // De exemplu, puteți adăuga o metodă pentru a căuta notițe după titlu:
}

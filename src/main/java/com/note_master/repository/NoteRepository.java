package com.note_master.repository;

import com.note_master.entity.NoteEntity;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@EntityScan
public interface NoteRepository extends JpaRepository<NoteEntity, Long> {


    List<NoteEntity> findByUserId(Integer userId);

    NoteEntity findByTitle(String title);

}

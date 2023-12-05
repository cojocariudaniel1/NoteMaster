package com.note_master.repository;

import com.note_master.entity.SharedNote;
import com.note_master.entity.Utilizator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SharedNoteRepository extends JpaRepository<SharedNote, Long> {

    SharedNote findSharedNoteByUtilizator(Utilizator utilizator);
}

package com.note_master.service;

import com.note_master.entity.SharedNote;
import com.note_master.entity.Utilizator;
import com.note_master.repository.SharedNoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SharedNoteService {
    private final SharedNoteRepository sharedNoteRepository;

    @Autowired
    public SharedNoteService(SharedNoteRepository sharedNoteRepository) {
        this.sharedNoteRepository = sharedNoteRepository;
    }

    public List<SharedNote> getAllSharedNotes() {
        return sharedNoteRepository.findAll();
    }

    public SharedNote getSharedNoteById(Long id) {
        return sharedNoteRepository.findById(id).orElse(null);
    }

    public SharedNote getSharedNotesByUtilizator(Utilizator utilizator) {
        return this.sharedNoteRepository.findSharedNoteByUtilizator(utilizator);
    }

    public SharedNote createSharedNote(SharedNote sharedNote) {
        return sharedNoteRepository.save(sharedNote);
    }

    public void saveSharedNote(SharedNote sharedNote) {
        this.sharedNoteRepository.save(sharedNote);
    }
    public void JPATestClear() {
        sharedNoteRepository.deleteAll();
    }
}

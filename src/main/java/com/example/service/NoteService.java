package com.example.service;

import com.example.entity.NoteEntity;
import com.example.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    private final NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    // Metode pentru CRUD
    public List<NoteEntity> getAllNotes() {
        return noteRepository.findAll();
    }

    public NoteEntity getNoteById(Long id) {
        return noteRepository.findById(id).orElse(null);
    }

    public NoteEntity createNote(NoteEntity note) {
        return noteRepository.save(note);
    }

    public NoteEntity updateNote(Long id, NoteEntity updatedNote) {
        NoteEntity existingNote = noteRepository.findById(id).orElse(null);
        if (existingNote != null) {
            // Actualizați proprietățile notiței existente cu cele din updatedNote
            existingNote.setTitle(updatedNote.getTitle());
            existingNote.setContent(updatedNote.getContent());
            // Alte proprietăți pot fi actualizate aici
            return noteRepository.save(existingNote);
        }
        return null;
    }

    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }
}

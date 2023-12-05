package com.note_master.service;

import com.note_master.entity.Note;
import com.note_master.entity.Utilizator;
import com.note_master.repository.NoteRepository;
import com.note_master.repository.UtilizatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NoteService {

    private final NoteRepository noteRepository;
    private final UtilizatorRepository utilizatorRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository, UtilizatorRepository utilizatorRepository) {
        this.noteRepository = noteRepository;
        this.utilizatorRepository = utilizatorRepository;
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Note getNoteById(Long id) {
        return noteRepository.findById(id).orElse(null);
    }

    public Note getNoteByTitle(String title){
        return noteRepository.getNoteByTitle(title);
    }

    public Note addNoteForUser(Long user_id, Note note) {
        Utilizator utilizator = utilizatorRepository.findById(user_id).orElse(null);
        if (utilizator != null) {
            utilizator.addNote(note);
            note.setUtilizator(utilizator);
            utilizatorRepository.save(utilizator);
            return note;
        }
        return null;
    }

    public void deleteNote(Note note) {
        this.noteRepository.delete(note);
    }

    public List<Note> getNotesByUserId(Long userId) {
        Utilizator utilizator = utilizatorRepository.findById(userId).orElse(null);
        return (utilizator != null) ? utilizator.getNotes() : List.of();
    }

    public void JPATestClear() {
        noteRepository.deleteAll();
    }

    public void saveNote(Note note1) {
        this.noteRepository.save(note1);
    }
}

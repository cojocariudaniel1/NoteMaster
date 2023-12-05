package com.note_master.service;



import com.note_master.entity.Note;
import com.note_master.entity.Utilizator;
import com.note_master.repository.NoteRepository;
import com.note_master.repository.UtilizatorRepository;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilizatorService {
    private final UtilizatorRepository utilizatorRepository;

    private final NoteRepository noteRepository;


    @Autowired
    public UtilizatorService(UtilizatorRepository utilizatorRepository, NoteRepository noteRepository) {
        this.utilizatorRepository = utilizatorRepository;
        this.noteRepository = noteRepository;

    }

    public List<Utilizator> getAllUsers() {return utilizatorRepository.findAll();}

    public Utilizator getUserById(int id) {return utilizatorRepository.findById((long) id).orElse(null);}

    public Utilizator createUser(Utilizator user) {
        return utilizatorRepository.save(user);

    }

    public Utilizator getUtilizatorByUsername(String username) {
        return utilizatorRepository.findByUsername(username);
    }

    public List<Note> getNotesFromUtilizator(String username) {
        Utilizator utilizator = this.utilizatorRepository.findByUsername(username);
        System.out.println(utilizator.getNotes());
        return utilizator.getNotes();
    }

    public void deleteUtilizator(Utilizator utilizator) {
        this.utilizatorRepository.delete(utilizator);
    }
    public void saveUtilizator(Utilizator user) {
        this.utilizatorRepository.save(user);
    }


    public void JPATestClear() {
        utilizatorRepository.deleteAll();
    }

}
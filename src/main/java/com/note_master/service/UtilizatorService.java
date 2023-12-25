package com.note_master.service;



import com.note_master.entity.Note;
import com.note_master.entity.Utilizator;
import com.note_master.repository.NoteRepository;
import com.note_master.repository.UtilizatorRepository;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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

    public Utilizator getUserById(Long id) {return utilizatorRepository.findById((long) id).orElse(null);}

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
    public Utilizator updateUtilizator(Long id, Utilizator utilizator) {
        Utilizator existingUtilizator = utilizatorRepository.findById(id).orElse(null);

        if (existingUtilizator != null) {
            // Actualizează câmpurile dorite ale utilizatorului existent cu valorile din obiectul primit
            existingUtilizator.setUsername(utilizator.getUsername());
            existingUtilizator.setPassword(utilizator.getPassword());

            // Salvează utilizatorul actualizat în baza de date
            return utilizatorRepository.save(existingUtilizator);
        }

        return null; // Poți decide să arunci o excepție sau să returnezi altceva în cazul în care utilizatorul cu ID-ul specificat nu este găsit
    }


    public void deleteUtilizator(int id) {
        Utilizator user = this.utilizatorRepository.findUserEntityById(id);
        this.utilizatorRepository.delete(user);
    }
    public void saveUtilizator(Utilizator user) {
        this.utilizatorRepository.save(user);
    }


    public void JPATestClear() {
        utilizatorRepository.deleteAll();
    }

    public Utilizator loginUtilizator(Utilizator utilizator) {
        System.out.println("DEBUG: loginUtilizator() ; Service");
        List<Utilizator> all_users = getAllUsers();

        int index = -1;
        for (int i = 0; i < all_users.size(); i ++) {
            if (Objects.equals(utilizator.getUsername(), all_users.get(i).getUsername())) {
                if (Objects.equals(utilizator.getPassword(), all_users.get(i).getPassword())) {
                    index = i;
                    System.out.println("Return " + all_users.get(i));

                };
            };

        };


        if (index != -1) {
            return all_users.get(index);
        }
        else {
            return null;
        }
    };
}
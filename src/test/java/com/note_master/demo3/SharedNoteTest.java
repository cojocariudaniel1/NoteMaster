package com.note_master.demo3;


import com.note_master.entity.Note;
import com.note_master.entity.SharedNote;
import com.note_master.entity.Utilizator;
import com.note_master.repository.NoteRepository;
import com.note_master.repository.SharedNoteRepository;
import com.note_master.repository.UtilizatorRepository;
import com.note_master.service.*;
import jdk.jshell.execution.Util;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class SharedNoteTest {

    @Autowired
    private SharedNoteService sharedNoteService;

    @Autowired
    private UtilizatorService utilizatorService;

    @Autowired
    private NoteService noteService;

    @Autowired
    private ReminderService reminderService;

    @Autowired
    private EventService eventService;

    @Autowired
    private CalendarService calendarService;

    @Autowired
    private SharedNoteRepository sharedNoteRepository;

    @Autowired
    private UtilizatorRepository utilizatorRepository;


    void setUp() {
        reminderService.JPATestClear();
        eventService.JPATestClear();
        sharedNoteService.JPATestClear();
        noteService.JPATestClear();
        calendarService.JPATestClear();
        utilizatorService.JPATestClear();
    }
    @Test
    void testCreateSharedNoteEvent() {
        setUp();
        Utilizator user1 = new Utilizator("User1", "Parola1", "email");
        Utilizator user2 = new Utilizator("User2", "Parola2", "email");


        Note note1 = new Note("Note1");

        user1.addNote(note1);

        SharedNote snote = new SharedNote(note1, user2);

        utilizatorService.saveUtilizator(user1);
        utilizatorService.saveUtilizator(user2);
        sharedNoteRepository.save(snote);

        //Cautare snote si utilizator care a fost atribuit

        SharedNote snote1 = sharedNoteRepository.findSharedNoteByUtilizator(user2);
        Utilizator user222 = utilizatorRepository.findByUsername("User2");

        assertNotNull(snote1);
        assertNotNull(user222);

        assertEquals(snote1.getUser().getId(), user222.getId());

    }

    @Test
    void testDeleteSharedNote() {
        Utilizator user = utilizatorRepository.findByUsername("User2");
        SharedNote snote = sharedNoteRepository.findSharedNoteByUtilizator(user);

        assertNotNull(snote);
        assertNotNull(user);

        sharedNoteRepository.delete(snote);
        assertEquals(0, sharedNoteRepository.findAll().size());

    }
}

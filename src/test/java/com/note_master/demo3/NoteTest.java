package com.note_master.demo3;

import com.note_master.entity.Note;
import com.note_master.entity.Utilizator;
import com.note_master.service.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class NoteTest {

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

    void setUp() {
        reminderService.JPATestClear();
        eventService.JPATestClear();
        sharedNoteService.JPATestClear();
        noteService.JPATestClear();
        calendarService.JPATestClear();
        utilizatorService.JPATestClear();
    }
    @Test
    public void CreateNoteTest() {
        setUp();

        Utilizator user1 = new Utilizator("User1", "Parola1");

        Note note1 = new Note("Note1");
        Note note2= new Note("Note2");

        note1.setUtilizator(user1);
        note2.setUtilizator(user1);
        utilizatorService.saveUtilizator(user1);
        noteService.saveNote(note1);
        noteService.saveNote(note2);


        Note new_note1 = noteService.getNoteByTitle("Note2");
        assertNotNull(new_note1);

        noteService.deleteNote(new_note1);

        assertEquals(1, noteService.getAllNotes().size());
    }
}

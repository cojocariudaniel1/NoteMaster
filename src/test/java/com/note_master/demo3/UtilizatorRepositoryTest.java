package com.note_master.demo3;

import com.note_master.entity.Utilizator;
import com.note_master.repository.SharedNoteRepository;
import com.note_master.repository.UtilizatorRepository;
import com.note_master.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class UtilizatorRepositoryTest {

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
    void testSaveAndRetrieveUser() {
        setUp();
        Utilizator user = new Utilizator();
        user.setUsername("john_doe");
        user.setEmail("john@example.com");

        utilizatorService.saveUtilizator(user);
        Utilizator savedUser = utilizatorRepository.findByUsername("john_doe");

        assertNotNull(savedUser);
        assertEquals("john@example.com", savedUser.getEmail());
    }

    @Test
    void testDeleteUser() {
        Utilizator savedUser = utilizatorRepository.findByUsername("john_doe");

        assertNotNull(savedUser);

        utilizatorRepository.delete(savedUser);
        assertEquals(0, utilizatorRepository.count());
    }
}

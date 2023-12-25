package com.note_master.demo3;

import com.note_master.entity.Calendar;
import com.note_master.entity.Utilizator;
import com.note_master.service.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
public class CalendarTest {
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




    @BeforeEach
    void setUp() {
        reminderService.JPATestClear();
        eventService.JPATestClear();
        sharedNoteService.JPATestClear();
        noteService.JPATestClear();
        calendarService.JPATestClear();
        utilizatorService.JPATestClear();
    }

    @Test
    public void testCreateCalendar() {
        Utilizator user = new Utilizator("Daniel", "Parola1", "email@test.com");
        Calendar calendar = new Calendar(user);
        utilizatorService.saveUtilizator(user);
        calendarService.saveCalendar(calendar);

        Calendar scalendar = calendarService.getCalendarByUtilizator(user);
        assertNotNull(scalendar);
        assertEquals(scalendar.getUtilizator().getId(), user.getId());

    }
}

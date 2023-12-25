package com.note_master.demo3;

import com.note_master.entity.Calendar;
import com.note_master.entity.Event;
import com.note_master.entity.Utilizator;
import com.note_master.repository.EventRepository;
import com.note_master.service.*;
import jakarta.transaction.Transactional;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest()
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EventTest {
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
    private EventRepository eventRepository;



    void setUp() {
        reminderService.JPATestClear();
        eventService.JPATestClear();
        sharedNoteService.JPATestClear();
        noteService.JPATestClear();
        calendarService.JPATestClear();
        utilizatorService.JPATestClear();
    }

    @Order(1)
    @Test
    public void TestCreateEvent() throws ParseException {
        setUp();
        Utilizator user = new Utilizator("Daniel", "123", "email");
        Calendar calendar = new Calendar(user);
        Event event = new Event("Event1", "Locatie 1", "12-02-2023", calendar);
        Event event2 = new Event("Event2", "Locatie 2", "14-02-2023", calendar);

        utilizatorService.saveUtilizator(user);
        calendarService.saveCalendar(calendar);
        eventService.saveEvent(event);
        eventService.saveEvent(event2);

        // Verificare daca exista in baza de date.
        Event new_event = eventService.getEventByTitle("Event1");
        Event new_event2 = eventService.getEventByTitle("Event2");

        assertNotNull(new_event);
        assertNotNull(new_event2);
        assertEquals(new_event.getId(), event.getId());
        assertEquals(new_event2.getId(), event2.getId());

    }
    @Order(2)
    @Test
    public void TestDeleteEvent(){
        Event event = eventService.getEventByTitle("Event2");
        assertNotNull(event);
        eventService.deleteEvent(event);
        System.out.println(eventService.getAllEvents());
        assertEquals(1, eventService.getAllEvents().size());
    }


}

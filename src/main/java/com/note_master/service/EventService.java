package com.note_master.service;

import com.note_master.entity.Calendar;
import com.note_master.entity.Event;
import com.note_master.repository.CalendarRepository;
import com.note_master.repository.EventRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final CalendarRepository calendarRepository;


    @Autowired
    public EventService(EventRepository eventRepository, CalendarRepository calendarRepository) {
        this.eventRepository = eventRepository;
        this.calendarRepository = calendarRepository;
    }



    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

    public Event getEventByTitle(String title) {
        return this.eventRepository.findByTitle(title);
    }

    public void saveEvent(Event event) {
        eventRepository.save(event);
    }


    public void deleteEvent(Event event) {
        this.eventRepository.delete(event);
    }

    public void deleteEventById(Long id) {
        eventRepository.deleteById(id);
    }
    public void JPATestClear() {
        eventRepository.deleteAll();
    }
}

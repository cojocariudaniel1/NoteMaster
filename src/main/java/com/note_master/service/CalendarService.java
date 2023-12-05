package com.note_master.service;

import com.note_master.entity.Calendar;
import com.note_master.entity.Event;
import com.note_master.entity.Utilizator;
import com.note_master.repository.CalendarRepository;
import com.note_master.repository.EventRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarService {
    
    private final CalendarRepository calendarRepository;

    private final EventRepository eventRepository;

    @Autowired
    public CalendarService(CalendarRepository calendarRepository, EventRepository eventRepository) {
        this.calendarRepository = calendarRepository;
        this.eventRepository = eventRepository;
    }
    public List<Calendar> getAllCalendars() {
        return calendarRepository.findAll();
    }

    public Calendar getCalendarById(Long id) {
        return calendarRepository.findById(id).orElse(null);
    }

    public void saveCalendar(Calendar calendar) {
        calendarRepository.save(calendar);
    }

    public Calendar getCalendarByUtilizator(Utilizator utilizator) {
        return calendarRepository.findCalendarByUtilizator(utilizator);
    }

    public void deleteCalendar(Long id) {
        calendarRepository.deleteById(id);
    }

    public void JPATestClear() {
        calendarRepository.deleteAll();
    }
}

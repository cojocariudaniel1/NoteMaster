package com.note_master.repository;

import com.note_master.entity.Calendar;
import com.note_master.entity.Event;
import com.note_master.entity.Utilizator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar, Long> {
    Calendar findCalendarByUtilizator(Utilizator utilizator);

}

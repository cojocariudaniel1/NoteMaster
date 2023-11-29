package com.note_master.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Calendar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "calendar", cascade = CascadeType.ALL)
    private List<Event> events;

    public Calendar(Long id, List<Event> events) {
        this.id = id;
        this.events = events;
    }

    public Calendar() {

    }

    public Long getId() {
        return id;
    }
    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}

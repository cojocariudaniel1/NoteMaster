package com.note_master.entity;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;

import java.util.List;

@Entity
public class Calendar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @OneToOne
    private Utilizator utilizator;
    @OneToMany(mappedBy = "calendar", orphanRemoval = true)
    private List<Event> events;

    public Calendar(Utilizator utilizator) {
        this.utilizator = utilizator;
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

    public Utilizator getUtilizator() {
        return utilizator;
    }

    public void setUtilizator(Utilizator utilizator) {
        this.utilizator = utilizator;
    }
}

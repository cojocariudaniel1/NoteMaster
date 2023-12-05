package com.note_master.entity;

import jakarta.persistence.*;

import java.sql.Time;

@Entity
public class Reminder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Time time;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Utilizator utilizator; // Schimbat numele câmpului la Utilizator

    public Reminder(Long id, Time time) {
        this.id = id;
        this.time = time;
    }

    public Reminder() {

    }

    public Long getId() {
        return id;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Utilizator getUtilizator() { // Schimbat numele metodei la getUtilizator
        return utilizator;
    }

    public void setUtilizator(Utilizator utilizator) {
        this.utilizator = utilizator;
    }
}

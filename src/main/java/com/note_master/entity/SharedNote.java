package com.note_master.entity;

import jakarta.persistence.*;

import java.security.Permissions;
@Entity
public class SharedNote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Note note;

    @ManyToOne
    private Utilizator utilizator;


    public SharedNote(Note note, Utilizator user) {
        this.note = note;
        this.utilizator = user;

    }

    public SharedNote() {

    }

    public Long getId() {
        return id;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public Utilizator getUser() {
        return utilizator;
    }

    public void setUser(Utilizator utilizator) {
        this.utilizator = utilizator;
    }
}

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
    private Utilizator user;


    public SharedNote(Note note, Utilizator user) {
        this.note = note;
        this.user = user;

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
        return user;
    }

    public void setUser(Utilizator user) {
        this.user = user;
    }
}

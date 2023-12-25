package com.note_master.entity;

import jakarta.persistence.*;
import jdk.jshell.execution.Util;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Utilizator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;
    private String password;

    private String email;

    private LocalDate creationDate;

    @OneToMany(mappedBy = "utilizator", cascade = CascadeType.ALL)
    private List<Note> notes = new ArrayList<>();

    @OneToMany(mappedBy = "utilizator", cascade = CascadeType.ALL)
    private List<Reminder> reminders = new ArrayList<>();

    public Utilizator(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.creationDate = LocalDate.now();
    }

    public Utilizator() {
        this.creationDate = LocalDate.now();
    }


    public List<Note> getNotes(){
        return notes;
    }

    public void addReminder(Reminder reminder) {
        reminders.add(reminder);
    }

    public List<Reminder> getReminders() {
        return reminders;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public void addNote(Note note) {
        this.notes.add(note);
    }
}

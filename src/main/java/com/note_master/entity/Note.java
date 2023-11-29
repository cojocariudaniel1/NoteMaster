package com.note_master.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private Date date;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private Utilizator user;

    public Note(String title, Date date, Utilizator user) {
        this.title = title;
        this.date = date;
        this.user = user;
    }

    public Note() {

    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Utilizator getUser() {
        return user;
    }

    public void setUser(Utilizator user) {
        this.user = user;
    }
}

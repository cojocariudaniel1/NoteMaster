package com.note_master.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String location;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "calendar_id")
    private Calendar calendar;

    public Event(Long id, String title, String location, Date date, Calendar calendar) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.date = date;
        this.calendar = calendar;
    }

    public Event() {
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }
}

package cz.uhk.fim.workshop.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalTime;
import java.util.Date;

@Entity
@Table (name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 64)
    private String name;

    @Column(length = 512)
    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "hh:mm")
    private LocalTime time;

    @Column(name = "is_public", columnDefinition = "boolean default false")
    private Boolean publicEvent;

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getPublicEvent() {
        return publicEvent;
    }

    public void setPublicEvent(Boolean aPublic) {
        publicEvent = aPublic;
    }

    public Event() {
    }

    public Event(Integer id, String name, String description, Date date, LocalTime time, Boolean publicEvent) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.description = description;
        this.time = time;
    }

}

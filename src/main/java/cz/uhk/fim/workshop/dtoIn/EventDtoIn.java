package cz.uhk.fim.workshop.dtoIn;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalTime;
import java.util.Date;

public class EventDtoIn {

    private Integer id;

    @NotBlank(message = "Name is mandatory")
    @Length(min = 3, max = 64, message = "Name can be minimum of 3 and maximum of 64 characters")
    private String name;

    @Length(max = 512, message = "Description can be maximum of 512 characters")
    private String description;

    @NotNull(message = "date is mandatory")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    @NotNull(message = "time mandatory")
    @DateTimeFormat(pattern = "hh:mm")
    private LocalTime time;

    @NotNull(message = "publicEvent is madnatory")
    private boolean publicEvent;

    public boolean isPublicEvent() {
        return publicEvent;
    }

    public void setPublicEvent(boolean publicEvent) {
        this.publicEvent = publicEvent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}

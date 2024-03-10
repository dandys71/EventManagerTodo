package cz.uhk.fim.workshop.dtoOut;

import com.fasterxml.jackson.annotation.JsonIgnore;
import cz.uhk.fim.workshop.model.Event;

public class EventDtoOut extends Event {
    @JsonIgnore
    private Integer id;
}

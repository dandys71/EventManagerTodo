package cz.uhk.fim.workshop.controller;

import cz.uhk.fim.workshop.dtoIn.EventDtoIn;
import cz.uhk.fim.workshop.model.Event;
import cz.uhk.fim.workshop.service.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EventApiController {
    @Autowired
    private EventService service;

    @GetMapping("/getEventList")
    public List<Event> getEvents(){
        return service.getEvents();
    }

    @PostMapping("/addEvent")
    public Event addEvent(@Valid @RequestBody EventDtoIn e){

        return new Event();
        //return service.addEvent(e);
    }

}

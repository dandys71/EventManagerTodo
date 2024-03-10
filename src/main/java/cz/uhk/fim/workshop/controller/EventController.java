package cz.uhk.fim.workshop.controller;

import cz.uhk.fim.workshop.dtoIn.EventDtoIn;
import cz.uhk.fim.workshop.exeption.EventNotFoundException;
import cz.uhk.fim.workshop.model.Event;
import cz.uhk.fim.workshop.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class EventController {

    @Autowired
    private EventService service;

    @GetMapping("/events")
    public String showEvents(Model model){
        List<Event> events = service.getEvents();
        model.addAttribute("eventList", events);
        return "events";
    }

    @GetMapping("/events/add")
    public String showNewForm(Model model){
        model.addAttribute("event", new Event());
        return "event_form";
    }

    @PostMapping("/events/save")
    public String saveEvent(Event e, RedirectAttributes ra){
        service.addEvent(e);
        ra.addAttribute("message", "Event was added");
        return "redirect:/events";
    }

    @GetMapping("/events/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model){

        try {
            Event e = service.getEvent(id);
            model.addAttribute("event", e);
        } catch (EventNotFoundException ex) {

            throw new RuntimeException(ex);
        }

        return "event_form";
    }

    @GetMapping("/events/delete/{id}")
    public String deleteEvent(@PathVariable("id") int id, RedirectAttributes ra){
        try{
            service.removeEvent(id);
            ra.addFlashAttribute("message", "Event was successfully removed");
        }catch (EventNotFoundException ex){
            ra.addFlashAttribute("error", ex.getMessage());
        }
        return "redirect:/events";
    }
}

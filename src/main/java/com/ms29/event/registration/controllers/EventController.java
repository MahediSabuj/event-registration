package com.ms29.event.registration.controllers;

import com.ms29.event.registration.entities.Event;
import com.ms29.event.registration.services.EventService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/event")
@AllArgsConstructor
public class EventController {
    private final EventService eventService;

    @GetMapping("/create")
    public String showCreateEventForm(Model model) {
        model.addAttribute("event", new Event());
        return "event/create";
    }

    @PostMapping("/create")
    public String createEvent(@ModelAttribute Event event) {
        eventService.createEvent(event);
        return "redirect:/event/list";
    }

    @GetMapping("/list")
    public String listEvents(Model model) {
        model.addAttribute("events", eventService.getAllEvents());
        return "event/list";
    }
}

package com.springbootintro.controller;

import com.springbootintro.business.domain.model.Event;
import com.springbootintro.business.repository.storage.Storage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EventController {

    @GetMapping(path = "/event")
    public Event getEvent(@PathVariable Event event) { return  event; }

    @GetMapping(path = "/event/title")
    public List<Event> getEventsByTitle(@PathVariable String title, int pageSize, int pageNum) {
        return Storage.eventRepositoryMap.values().stream()
                .filter(event -> event.getTitle().contains(title))
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/event/date")
    public List<Event> getEventsForDay(@PathVariable Date day, int pageSize, int pageNum) {
        return Storage.eventRepositoryMap.values().stream()
                .filter(event -> event.getDate().equals(day))
                .collect(Collectors.toList());
    }
}

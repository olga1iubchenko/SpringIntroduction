package com.springbootintro.business.repository.dao;

import com.springbootintro.business.domain.model.Event;
import com.springbootintro.business.repository.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EventDAO {

    @Autowired
    Storage storage;


    public Event getEventById(long eventId) {
        return storage.getEventById(eventId);
    }

    public Event getEventByTitle(String title) {
        return (Event) Storage.eventRepositoryMap.values().stream()
                .filter(event -> event.getTitle().equals(title));
    }

    public List<Event> getEventsByTitle(String title) {
        return Storage.eventRepositoryMap.values().stream()
                .filter(event -> event.getTitle().contains(title))
                .collect(Collectors.toList());
    }

    public Event createEvent(Event event) {
        storage.saveEvent(event);
        return event;
    }

    public Event updateEvent(Event event) {
        Storage.eventRepositoryMap.put(event.getId(), event);
        return event;
    }

    public boolean deleteEvent(long eventId) {
        if (Storage.eventRepositoryMap.get(eventId) != null) {
            Storage.eventRepositoryMap.remove(eventId);
            return true;
        } else return false;
    }

}

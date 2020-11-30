package com.springbootintro.business.repository.storage;

import com.springbootintro.business.domain.model.Event;
import com.springbootintro.business.domain.model.Ticket;
import com.springbootintro.business.domain.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Repository
public class Storage {

    public static HashMap<Long, Event> eventRepositoryMap = new HashMap<>();

    public static HashMap<Long, Ticket> ticketRepositoryMap = new HashMap<>();

    public static HashMap<Long, User> userRepositoryMap = new HashMap<>();

    public synchronized Event getEventById(long eventId) {
        return eventRepositoryMap.get(eventId);
    }

    public synchronized List<Event> getAllEvents() {
        return new ArrayList<>(eventRepositoryMap.values());
    }

    public synchronized Event saveEvent(Event event) {

        eventRepositoryMap.put(event.getId(), event);

        return event;
    }

    public synchronized User getUserById(long userId) {

        return userRepositoryMap.get(userId);
    }

    public synchronized List<User> getAllUsers() {
        return new ArrayList<>(userRepositoryMap.values());
    }

    public synchronized User saveUser(User user) {

        userRepositoryMap.put(user.getId(), user);

        return user;
    }

    public synchronized Ticket getTicketById(long ticketId) {
        return ticketRepositoryMap.get(ticketId);
    }

    public synchronized List<Ticket> getAllTickets() {

        return new ArrayList<>(ticketRepositoryMap.values());
    }

    public synchronized Ticket saveTicket(Ticket ticket) {

        ticketRepositoryMap.put(ticket.getId(), ticket);

        return ticket;
    }

}

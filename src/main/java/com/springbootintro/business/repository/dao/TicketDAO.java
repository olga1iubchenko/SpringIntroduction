package com.springbootintro.business.repository.dao;

import com.springbootintro.business.domain.entity.TicketEntity;
import com.springbootintro.business.domain.model.Event;
import com.springbootintro.business.domain.model.Ticket;
import com.springbootintro.business.domain.model.User;
import com.springbootintro.business.repository.storage.Storage;
import com.springbootintro.helper.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TicketDAO {

    private String category;

    TicketEntity ticketEntity;

    @Autowired
    Storage storage;

    public Ticket createTicket(Ticket ticket) throws IdNotFoundException {
       storage.saveTicket(ticket);
       return ticket;
    }

    public Ticket bookTicket(long userId, long eventId, int place, String category) throws IdNotFoundException {
        ticketEntity.setUserId(userId);
        ticketEntity.setEventId(eventId);
        ticketEntity.setPlace(place);
        ticketEntity.setCategory(category);
        return ticketEntity;
    }

    public Ticket getTicketById(long ticketId) {
        return storage.getTicketById(ticketId);
    }

    public Ticket getBookedTicketByEvent(Event event, int pageSize, int pageNum) {
        return (Ticket) Storage.ticketRepositoryMap.values().stream()
                .filter(ticket -> ticket.getEventId() == event.getId());
    }

    public List<Ticket> getBookedTicketsByEvent(Event event, int pageSize, int pageNum) {
        return Storage.ticketRepositoryMap.values().stream()
                .filter(ticket -> ticket.getEventId() == event.getId())
                .collect(Collectors.toList());
    }

    public List<Ticket> getBookedTicketsByUser(User user, int pageSize, int pageNum) {
        return Storage.ticketRepositoryMap.values().stream()
                .filter(ticket -> ticket.getUserId() ==user.getId())
                .collect(Collectors.toList());
    }



    public boolean cancelTicket(long ticketId) {
        if (Storage.ticketRepositoryMap.get(ticketId) != null) {
            Storage.ticketRepositoryMap.remove(ticketId);
            return true;
        } else return false;
    }

}

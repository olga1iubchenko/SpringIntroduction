package com.springbootintro.controller;

import com.springbootintro.business.domain.model.Event;
import com.springbootintro.business.domain.model.Ticket;
import com.springbootintro.business.repository.storage.Storage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TicketController {

    @GetMapping(path = "/ticket")
    public Ticket getTicket(@PathVariable Ticket ticket) { return ticket; }

    @GetMapping(path = "tickets/event")
    public List<Ticket> getBookedTicketsByEvent(@PathVariable Event event, int pageSize, int pageNum) {
        return Storage.ticketRepositoryMap.values().stream()
                .filter(ticket -> ticket.getEventId() == event.getId())
                .collect(Collectors.toList());
    }
}


package com.springbootintro.business.service;

import com.springbootintro.controller.EventController;
import com.springbootintro.controller.UserController;
import com.springbootintro.business.domain.model.Event;
import com.springbootintro.business.domain.model.Ticket;
import com.springbootintro.business.domain.model.User;
import com.springbootintro.business.facade.BookingFacade;
import com.springbootintro.business.repository.dao.EventDAO;
import com.springbootintro.business.repository.dao.TicketDAO;
import com.springbootintro.business.repository.dao.UserDAO;
import com.springbootintro.helper.IdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookingFacadeService implements BookingFacade {

    @Autowired
    EventDAO eventDAO;

    @Autowired
    UserDAO userDAO;

    @Autowired
    TicketDAO ticketDAO;

    @Autowired
    EventController eventController;

    @Autowired
    UserController userController;

    @Override
    public Event getEventById(long eventId) {
        return eventDAO.getEventById(eventId);
    }

    @Override
    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        return (eventController.getEventsByTitle(title, pageSize, pageNum));
    }

    @Override
    public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
        return eventController.getEventsForDay(day, pageSize, pageNum);
    }

    @Override
    public Event createEvent(Event event) {
        return eventDAO.createEvent(event);
    }

    @Override
    public Event updateEvent(Event event) {
        return eventDAO.updateEvent(event);
    }

    @Override
    public boolean deleteEvent(long eventId) {

        return eventDAO.deleteEvent(eventId);
    }

    @Override
    public User getUserById(long userId) {

        return userDAO.getUserById(userId);
    }

    @Override
    public User getUserByEmail(String email) {

        return userDAO.getUserByEmail(email);
    }

    @Override
    public List<User> getUsersByName(String name, int pageSize, int pageNum) {

        return userController.getUsersByName(name, pageSize, pageNum);
    }

    @Override
    public User createUser(User user) {

        return userDAO.createUser(user);
    }

    @Override
    public User updateUser(User user) {

        return userDAO.updateUser(user);
    }

    @Override
    public boolean deleteUser(long userId) {

        return userDAO.deleteUser(userId);
    }

    @Override
    public Ticket bookTicket(long userId, long eventId, int place, String category) throws IdNotFoundException {
        return ticketDAO.bookTicket(userId, eventId, place, category);
    }

    @Override
    public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
        return ticketDAO.getBookedTicketsByUser(user, pageSize, pageNum);
    }

    @Override
    public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
        return ticketDAO.getBookedTicketsByEvent(event, pageSize, pageNum);
    }

    @Override
    public boolean cancelTicket(long ticketId) {

        return ticketDAO.cancelTicket(ticketId);
    }
}

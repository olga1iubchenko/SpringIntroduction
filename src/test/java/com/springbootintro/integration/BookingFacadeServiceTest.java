package com.springbootintro.integration;

import com.springbootintro.business.domain.entity.EventEntity;
import com.springbootintro.business.domain.entity.TicketEntity;
import com.springbootintro.business.domain.entity.UserEntity;
import com.springbootintro.business.domain.model.Ticket;
import com.springbootintro.business.service.BookingFacadeService;
import com.springbootintro.helper.IdNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class BookingFacadeServiceTest {

    @Autowired
    private BookingFacadeService bookingFacadeService;

    @Test
    public void testFindBookedTickets() throws IdNotFoundException {
        EventEntity event = new EventEntity(701, "Summer", new Date());
        UserEntity user = new UserEntity(702, "Isabella", "bella@gmail.com");
        TicketEntity ticket = new TicketEntity(703, event,user, Ticket.Category.STANDARD, 31);


        bookingFacadeService.bookTicket(user.getId(), event.getId(), 33, "STANDARD");

        List<Ticket> expectedTicket = null;
        expectedTicket.add(ticket);

        assertEquals(expectedTicket, bookingFacadeService.getBookedTickets(user, 2, 2));

        }
    }

package com.springbootintro.unit.service;

import com.springbootintro.business.domain.entity.EventEntity;
import com.springbootintro.business.domain.entity.TicketEntity;
import com.springbootintro.business.domain.entity.UserEntity;
import com.springbootintro.business.domain.model.Ticket;
import com.springbootintro.business.repository.storage.Storage;
import com.springbootintro.business.service.TicketService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class TicketServiceTest {

    @Mock
    private Storage storage;

    @InjectMocks
    private TicketService ticketService;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddContactHappyPath() {

        TicketEntity ticket = new TicketEntity(403, new EventEntity(404, "TicketEvent", new Date()), new UserEntity(405, "Bob", "Bob@gmail.com"), Ticket.Category.STANDARD, 31);

        when(storage.saveTicket(any(TicketEntity.class))).thenReturn(ticket);

        TicketEntity newTicket = (TicketEntity) ticketService.getTicket(ticket);

        assertEquals(403, newTicket.getId());
    }
}
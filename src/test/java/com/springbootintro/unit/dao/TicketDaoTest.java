package com.springbootintro.unit.dao;

import com.springbootintro.business.domain.entity.EventEntity;
import com.springbootintro.business.domain.entity.TicketEntity;
import com.springbootintro.business.domain.entity.UserEntity;
import com.springbootintro.business.domain.model.Ticket;
import com.springbootintro.business.repository.dao.TicketDAO;
import com.springbootintro.helper.IdNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class TicketDaoTest {

    @Autowired
    private TicketDAO ticketDAO;

    @Test
    public void testFindById() throws IdNotFoundException {
        TicketEntity ticket = new TicketEntity(603, new EventEntity(604, "TicketEvent", new Date()), new UserEntity(605, "Bob", "Bob@gmail.com"), Ticket.Category.STANDARD, 31);
        ticketDAO.createTicket(ticket);
        TicketEntity ticketFromDAO = (TicketEntity) ticketDAO.getTicketById(604);

        assertEquals(604, ticketFromDAO.getId());
    }
}

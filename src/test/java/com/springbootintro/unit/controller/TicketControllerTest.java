package com.springbootintro.unit.controller;

import com.springbootintro.business.domain.entity.TicketEntity;
import com.springbootintro.business.repository.storage.Storage;
import com.springbootintro.controller.TicketController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class TicketControllerTest {

    @MockBean
    private Storage storage;

    @InjectMocks
    private TicketController ticketController;

    @Before
    public void setUp() { MockitoAnnotations.initMocks(this); }

    @Test
    public void testTicketByTitle() throws Exception {
        TicketEntity mockTicket = new TicketEntity();
        mockTicket.setId(503);
        mockTicket.setPlace(23);

        when(storage.saveTicket(any(TicketEntity.class))).thenReturn(mockTicket);

        TicketEntity newTicket = (TicketEntity) ticketController.getTicket(mockTicket);


        assertEquals(23, newTicket.getPlace());
    }
}

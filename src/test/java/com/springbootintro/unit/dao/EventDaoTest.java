package com.springbootintro.unit.dao;


import com.springbootintro.business.domain.entity.EventEntity;
import com.springbootintro.business.repository.dao.EventDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class EventDaoTest {

    @Autowired
    private EventDAO eventDAO ;

    @Test
    public void testFindByTitle() {
        EventEntity event = new EventEntity(601, "Life After Corona", new Date());
        eventDAO.createEvent(event);
        EventEntity eventFromDAO = (EventEntity) eventDAO.getEventByTitle("Life After Corona");

        assertEquals(event.getTitle(), eventFromDAO.getTitle());
    }
}

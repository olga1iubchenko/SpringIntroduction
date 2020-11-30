package com.springbootintro.unit.service;

import com.springbootintro.business.domain.entity.EventEntity;
import com.springbootintro.business.repository.storage.Storage;
import com.springbootintro.business.service.EventService;
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
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class EventServiceTest {

    @Mock
    private Storage storage;

    @InjectMocks
    private EventService eventService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddEventHappyPath() {

        EventEntity event = new EventEntity(401, "Life After Corona", new Date());

        when(storage.saveEvent(any(EventEntity.class))).thenReturn(event);

        EventEntity newEvent = (EventEntity) eventService.getEvent(event);

        assertEquals("Life After Corona", newEvent.getTitle());
    }
}

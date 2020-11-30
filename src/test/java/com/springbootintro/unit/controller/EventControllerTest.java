package com.springbootintro.unit.controller;

import com.springbootintro.business.domain.entity.EventEntity;
import com.springbootintro.business.repository.storage.Storage;
import com.springbootintro.controller.EventController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class EventControllerTest {

    @MockBean
    private Storage storage;

    @InjectMocks
    private EventController eventController;

    @Before
    public void setUp() { MockitoAnnotations.initMocks(this); }

    @Test
    public void testFindEventByTitle() throws Exception {
        EventEntity mockEvent = new EventEntity();
        mockEvent.setId(501);
        mockEvent.setTitle("Kafka");

        when(storage.saveEvent(any(EventEntity.class))).thenReturn(mockEvent);

        EventEntity newEvent = (EventEntity) eventController.getEvent(mockEvent);

        assertEquals("Kafka", newEvent.getTitle());
    }
}

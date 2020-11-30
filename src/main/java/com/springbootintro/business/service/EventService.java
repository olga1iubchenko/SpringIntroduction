package com.springbootintro.business.service;

import com.springbootintro.business.domain.entity.EventEntity;
import com.springbootintro.business.domain.model.Event;
import com.springbootintro.business.repository.dao.EventDAO;
import com.springbootintro.business.repository.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    EventEntity eventEntity;

    @Autowired
    EventDAO eventDAO;

    @Autowired
    Storage storage;

    public Event getEvent(Event event) { return  event; }

    public Event getEventById(long eventId) {
        return  storage.getEventById(eventId);
    }

    public Boolean isIdUnique(long id)  {
         if (eventDAO.getEventById(id).equals(id)) {
            return false;
        } else return true;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + eventEntity.getId() +
                ", title='" + eventEntity.getId() + '\'' +
                ", date='" + eventEntity.getTitle() + '\'' +
                '}';
    }
}

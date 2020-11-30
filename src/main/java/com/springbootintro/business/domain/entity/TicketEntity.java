package com.springbootintro.business.domain.entity;

import com.springbootintro.business.domain.model.Ticket;
import com.springbootintro.helper.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

public class TicketEntity implements Ticket {

    private static long id;
    private Category category;
    private int place;

    @Autowired
    EventEntity eventEntity;

    @Autowired
    UserEntity userEntity;

    public TicketEntity (long id, EventEntity eventEntity, UserEntity userEntity, Category category, int place) {
        this.id = id;
        this.eventEntity = eventEntity;
        this.userEntity = userEntity;
        this.category = category;
        this.place = place;
    }

    public TicketEntity () {
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) throws IdNotFoundException {
        if (id <= 0) {
            throw new IdNotFoundException(String.format("Id %s is invalid", id));
        } else this.id = id;
    }

    @Override
    public long getEventId() {
        return eventEntity.getId();
    }

    @Override
    public void setEventId(long eventId) throws IdNotFoundException {
        eventEntity.setId(eventId);
    }

    @Override
    public long getUserId() {
        return userEntity.getId();
    }

    @Override
    public void setUserId(long userId) throws IdNotFoundException {
        userEntity.setId(userId);
    }

    @Override
    public Category getCategory() {
        return category;
    }

    @Override
    public void setCategory(String category) {
        this.category = Category.valueOf(category);
    }

    @Override
    public int getPlace() {
        return place;
    }

    @Override
    public void setPlace(int place) {
        this.place = place;
    }
}

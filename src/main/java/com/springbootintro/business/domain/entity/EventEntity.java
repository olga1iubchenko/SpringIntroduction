package com.springbootintro.business.domain.entity;

import com.springbootintro.business.domain.model.Event;
import com.springbootintro.helper.IdNotFoundException;

import java.util.Date;

public class EventEntity implements Event {

    private long id;
    private String title;
    private Date date;

    public EventEntity (long id, String title, Date date) {
        this.id = id;
        this.title = title;
        this.date = date;
    }

    public EventEntity () {
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) throws IdNotFoundException {
        if ( id <= 0 ) {
            throw new IdNotFoundException(String.format("Id %s is invalid", id));
        } else this.id = id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public void setDate(Date date) {
        this.date = date;
    }

}

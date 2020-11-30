package com.springbootintro.business.domain.model;

import com.springbootintro.helper.IdNotFoundException;

import java.util.Date;

/**
 * Created by maksym_govorischev.
 */
public interface Event {
    /**
     * Event id. UNIQUE.
     * @return Event Id
     */
    long getId();
    void setId(long id) throws IdNotFoundException;
    String getTitle();
    void setTitle(String title);
    Date getDate();
    void setDate(Date date);
}

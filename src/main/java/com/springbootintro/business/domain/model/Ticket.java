package com.springbootintro.business.domain.model;

import com.springbootintro.helper.IdNotFoundException;

/**
 * Created by maksym_govorischev.
 */
public interface Ticket {
    public enum Category {STANDARD, PREMIUM, BAR}

    /**
     * Ticket Id. UNIQUE.
     * @return Ticket Id.
     */
    long getId();
    void setId(long id) throws IdNotFoundException;
    long getEventId();
    void setEventId(long eventId) throws IdNotFoundException;
    long getUserId();
    void setUserId(long userId) throws IdNotFoundException;
    Category getCategory();
    void setCategory(String category);
    int getPlace();
    void setPlace(int place);

}

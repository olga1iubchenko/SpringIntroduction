package com.springbootintro.business.service;

import com.springbootintro.business.domain.entity.EventEntity;
import com.springbootintro.business.domain.entity.TicketEntity;
import com.springbootintro.business.domain.entity.UserEntity;
import com.springbootintro.business.domain.model.Ticket;
import com.springbootintro.business.repository.dao.TicketDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    TicketEntity ticketEntity;
    EventEntity eventEntity;
    UserEntity userEntity;

       @Autowired
       TicketDAO ticketDAO;

    public Ticket getTicket(Ticket ticket) {
        return  ticket;
    }

    public Boolean isIdUnique(long id)  {
        if (ticketDAO.getTicketById(id).equals(id)) {
            return false;
        } else return true;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + ticketEntity.getId() +
                ", user='" + userEntity.getName() + '\'' +
                ", event='" + eventEntity.getTitle() + '\'' +
                ", category='" + ticketEntity.getCategory() + '\'' +
                ", place='" + ticketEntity.getPlace() + '\'' +
                '}';
    }
}

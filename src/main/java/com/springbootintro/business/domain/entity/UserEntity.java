package com.springbootintro.business.domain.entity;

import com.springbootintro.business.domain.model.User;
import com.springbootintro.helper.EmailNotFoundException;
import com.springbootintro.helper.IdNotFoundException;

public class UserEntity implements User {

    private long id;
    private String name;
    private String email;

    public UserEntity (long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public UserEntity () {
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
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
         this.name = name;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) throws EmailNotFoundException {
            if (email == "" || email.isEmpty())  {
                throw new EmailNotFoundException(String.format("Email %s is invalid!", id));
        } else this.email = email;
    }
}

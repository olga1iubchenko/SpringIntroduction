package com.springbootintro.business.service;

import com.springbootintro.business.domain.entity.UserEntity;
import com.springbootintro.business.domain.model.User;
import com.springbootintro.business.repository.dao.UserDAO;
import com.springbootintro.business.repository.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserEntity userEntity;

    @Autowired
    UserDAO userDAO;

    @Autowired
    Storage storage;

    public User getUser(User user) {
        return  user;
    }

    public User getUserById(long userId) {
        return  userDAO.getUserById(userId);
    }

    public Boolean isIdUnique(long id)  {
        if (userDAO.getUserById(id).equals(id)) {
            return false;
        } else return true;
    }

    public Boolean isEmailUnique(String email)  {
        if (userDAO.getUserByEmail(email).equals(email)) {
            return false;
        } else return true;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + userEntity.getId() +
                ", name='" + userEntity.getName() + '\'' +
                ", email='" + userEntity.getEmail() + '\'' +
                '}';
    }
}

package com.springbootintro.business.repository.dao;

import com.springbootintro.business.domain.model.User;
import com.springbootintro.business.repository.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDAO {

    @Autowired
    Storage storage;

    public User getUserById(long userId) {
        return  storage.getUserById(userId);
    }

    public User getUserByEmail(String email) {
        return (User) Storage.userRepositoryMap
            .values()
            .stream()
            .filter(user -> user.getEmail().equals(email));
    }

    public User createUser(User user) {
        Storage.userRepositoryMap.put(user.getId(), user);
        return user;
    }

    public User updateUser(User user) {
        Storage.userRepositoryMap.put(user.getId(), user);
        return user;
    }

    public boolean deleteUser(long userId) {
        if (Storage.userRepositoryMap.get(userId) != null) {
            Storage.userRepositoryMap.remove(userId);
            return true;
        } else return false;
    }

}

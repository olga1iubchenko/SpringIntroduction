package com.springbootintro.controller;

import com.springbootintro.business.domain.model.User;
import com.springbootintro.business.repository.storage.Storage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {

    @GetMapping(path = "/user")
    public User getUser(@PathVariable User user) { return  user; }


    @GetMapping(path = "users/name")
    public List<User> getUsersByName(@PathVariable String name, int pageSize, int pageNum) {
        return  Storage.userRepositoryMap.values().stream()
                .filter(user -> user.getName().contains(name))
                .collect(Collectors.toList());
    }
}

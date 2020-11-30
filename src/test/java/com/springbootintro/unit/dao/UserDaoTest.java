package com.springbootintro.unit.dao;

import com.springbootintro.business.domain.entity.UserEntity;
import com.springbootintro.business.repository.dao.UserDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class UserDaoTest {

    @Autowired
    private UserDAO userDAO;

    @Test
    public void testFindByEmail() {
        UserEntity user = new UserEntity(602, "Kate", "kate@gmail.com");
        userDAO.createUser(user);
        UserEntity userFromDAO = (UserEntity) userDAO.getUserByEmail("kate@gmail.com");

        assertEquals(user.getEmail(), userFromDAO.getEmail());
    }
}
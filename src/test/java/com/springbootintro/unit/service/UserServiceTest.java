package com.springbootintro.unit.service;

import com.springbootintro.business.domain.entity.UserEntity;
import com.springbootintro.business.repository.storage.Storage;
import com.springbootintro.business.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class UserServiceTest {

    @Mock
    private Storage storage;

    @InjectMocks
    private UserService userService;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddUserHappyPath() {

        UserEntity user = new UserEntity(402, "Jenny", "jenny@gmail.com");

        when(storage.saveUser(any(UserEntity.class))).thenReturn(user);

        UserEntity newUser = (UserEntity) userService.getUser(user);

        assertEquals("Jenny", newUser.getName());
    }

}

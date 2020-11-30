package com.springbootintro.unit.controller;

import com.springbootintro.business.domain.entity.UserEntity;
import com.springbootintro.business.repository.storage.Storage;
import com.springbootintro.controller.UserController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class UserControllerTest {

    @MockBean
    private Storage storage;

    @InjectMocks
    private UserController userController;

    @Before
    public void setUp() { MockitoAnnotations.initMocks(this); }

    @Test
    public void testFindEventByTitle() throws Exception {
        UserEntity mockUser = new UserEntity();
        mockUser.setId(502);
        mockUser.setName("Lily");

        when(storage.saveUser(any(UserEntity.class))).thenReturn(mockUser);

       UserEntity newUser = (UserEntity) userController.getUser(mockUser);

        assertEquals("Lily", newUser.getName());
    }

}

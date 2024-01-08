package com.senso.mboukhenaif.controller;

import com.senso.mboukhenaif.dto.UserDto;
import com.senso.mboukhenaif.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllUsers() {
        // Given
        var expectedUsers = Arrays.asList(new UserDto(), new UserDto());

        // When
        when(userService.getAllUsers()).thenReturn(expectedUsers);
        ResponseEntity<List<UserDto>> responseEntity = userController.getAllUsers();

        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedUsers, responseEntity.getBody());
    }

    @Test
    void testInsertUser() {
        // Given
        var userDto = new UserDto();
        var createdUser = new UserDto();

        // When
        when(userService.saveUser(userDto)).thenReturn(createdUser);
        ResponseEntity<UserDto> responseEntity = userController.insertUser(userDto);

        // Then
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(createdUser, responseEntity.getBody());
    }
}

package com.senso.mboukhenaif.service;

import com.senso.mboukhenaif.dto.UserDto;
import com.senso.mboukhenaif.entities.User;
import com.senso.mboukhenaif.repository.UserRepository;
import com.senso.mboukhenaif.service.impl.UserServiceImpl;
import com.senso.mboukhenaif.service.mapper.UserMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserServiceImplTest {

    private UserServiceImpl userService;
    private UserMapper userMapper;
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userMapper = Mappers.getMapper(UserMapper.class);
        userRepository = mock(UserRepository.class);
        userService = new UserServiceImpl();
        userService.setUserMapper(userMapper);
        userService.setUserRepository(userRepository);
    }

    @Test
    void shouldSaveUserEntity() {
        // Given
        var userDto = new UserDto();
        userDto.setUserId("user1");
        var savedUserEntity = userMapper.getUserEntityFromDto(userDto);

        when(userRepository.save(any(User.class))).thenReturn(savedUserEntity);

        // When
        var savedUserDto = userService.saveUser(userDto);

        // Then
        assertEquals(userDto.getUserId(), savedUserDto.getUserId());
    }

    @Test
    void shouldReturnListOfUserDtos() {
        // Given
        var userEntity = new User();
        userEntity.setUserId("user1");
        var userEntities = Collections.singletonList(userEntity);

        when(userRepository.findAll()).thenReturn(userEntities);

        // When
        var userDtos = userService.getAllUsers();

        // Then
        assertEquals(userEntities.size(), userDtos.size());
    }
}

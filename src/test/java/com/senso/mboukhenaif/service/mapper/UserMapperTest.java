package com.senso.mboukhenaif.service.mapper;

import com.senso.mboukhenaif.dto.UserDto;
import com.senso.mboukhenaif.entities.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserMapperTest {

    private UserMapper userMapper;

    @BeforeEach
    void setUp() {
        userMapper = Mappers.getMapper(UserMapper.class);
    }

    @Test
    void getUserFromEntity_shouldMapToUserDto() {
        // Given
        var userEntity = new User();
        userEntity.setUserId("user1");

        // When
        var userDto = userMapper.getUserFromEntity(userEntity);

        // Then
        assertEquals(userEntity.getUserId(), userDto.getUserId());
    }

    @Test
    void getUsersFromEntity_shouldMapToUserDtoList() {
        // Given
        var userEntities = Collections.singletonList(new User());

        // When
        var userDtos = userMapper.getUsersFromEntity(userEntities);

        // Then
        assertEquals(userEntities.size(), userDtos.size());
    }

    @Test
    void getUserEntityFromDto_shouldMapToUserEntity() {
        // Given
        var userDto = new UserDto();
        userDto.setUserId("user1");

        // When
        var userEntity = userMapper.getUserEntityFromDto(userDto);

        // Then
        assertEquals(userDto.getUserId(), userEntity.getUserId());
    }
}

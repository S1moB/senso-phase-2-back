package com.senso.mboukhenaif.service.mapper;

import com.senso.mboukhenaif.dto.UserDto;
import com.senso.mboukhenaif.entities.User;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Named(value = "getUserFromEntity")
    UserDto getUserFromEntity(User user);
    User getUserEntityFromDto(UserDto user);
    @IterableMapping(qualifiedByName = "getUserFromEntity")
    List<UserDto> getUsersFromEntity(List<User> users);
}

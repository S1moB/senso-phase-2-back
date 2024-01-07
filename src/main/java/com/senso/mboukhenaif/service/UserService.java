package com.senso.mboukhenaif.service;

import com.senso.mboukhenaif.dto.UserDto;

import java.util.List;


public interface UserService {
    UserDto saveUser(UserDto userDto);
    List<UserDto> getAllUsers();
}

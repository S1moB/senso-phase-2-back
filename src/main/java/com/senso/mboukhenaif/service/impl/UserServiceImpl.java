package com.senso.mboukhenaif.service.impl;

import com.senso.mboukhenaif.dto.UserDto;
import com.senso.mboukhenaif.repository.UserRepository;
import com.senso.mboukhenaif.service.UserService;
import com.senso.mboukhenaif.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;
    private UserRepository userRepository;

    @Override
    public UserDto saveUser(UserDto userDto) {
        return userMapper.getUserFromEntity(userRepository.save(userMapper.getUserEntityFromDto(userDto)));
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userMapper.getUsersFromEntity(userRepository.findAll());
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}

package com.senso.mboukhenaif.controller;

import com.senso.mboukhenaif.dto.UserDto;
import com.senso.mboukhenaif.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("/")
    public ResponseEntity<UserDto> insertUser(final @RequestBody UserDto user) {
        var userCreated = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}

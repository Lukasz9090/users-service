package com.users.controller;

import com.users.model.UserDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@RestController
@RequestMapping("/users")
public class UsersServiceController {

    private static List<UserDto> users = new ArrayList<>();

    static {
        users.add(new UserDto("1", "John Doe"));

    }

    @GetMapping()
    public ResponseEntity<List<UserDto>> getUsers() {
        log.info("Getting users");
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto user) {
        log.info("Adding user: {}", user);
        users.add(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}

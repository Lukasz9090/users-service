package com.users.controller;

import com.users.model.UserDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/users")
public class UsersServiceController {

    @GetMapping()
    public ResponseEntity<UserDto> getUsers() {

        log.info("Getting users");
        var user = new UserDto("1", "John Doe");
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}

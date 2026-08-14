package com.maks.youtubedownloader.controller;

import com.maks.youtubedownloader.dto.request.RegistrationRequest;
import com.maks.youtubedownloader.dto.response.RegistrationSuccessResponse;
import com.maks.youtubedownloader.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/registration")
    public ResponseEntity<RegistrationSuccessResponse> registerNewUser(@RequestBody @Valid
                                                                           RegistrationRequest registrationRequest) {
        RegistrationSuccessResponse response =  userService.createNewUser(registrationRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}

package com.maks.youtubedownloader.controller;

import com.maks.youtubedownloader.dto.request.RegistrationRequest;
import com.maks.youtubedownloader.service.UserService;
import jakarta.validation.Valid;
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
    public String registerNewUser(@RequestBody @Valid RegistrationRequest registrationRequest) {
        userService.createNewUser(registrationRequest);
        return "New user registered "+registrationRequest.getFirstName()+
                " "+registrationRequest.getLastName();
    }
}

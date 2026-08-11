package com.maks.youtubedownloader.service;

import com.maks.youtubedownloader.configuration.PasswordHashingRegistration;
import com.maks.youtubedownloader.dto.request.RegistrationRequest;
import com.maks.youtubedownloader.entity.User;
import com.maks.youtubedownloader.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    private final  UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                      PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public String createNewUser(RegistrationRequest registrationRequest) {
        if (!userRepository.findByEmail(registrationRequest.getEmail()) ) {
            User user = new User();

            user.setEmail(registrationRequest.getEmail());
            user.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
            user.setFirstName(registrationRequest.getFirstName());
            user.setLastName(registrationRequest.getLastName());
            userRepository.save(user);
            return "User created";

        }
        else{
            return "User already exists";
        }

    }
}

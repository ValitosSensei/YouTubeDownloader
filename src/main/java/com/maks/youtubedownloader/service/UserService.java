package com.maks.youtubedownloader.service;

import com.maks.youtubedownloader.configuration.GlobalException.GlobalExceptionHandler;
import com.maks.youtubedownloader.configuration.exceptions.UserAlreadyExistsException;
import com.maks.youtubedownloader.dto.request.RegistrationRequest;
import com.maks.youtubedownloader.dto.response.RegistrationSuccessResponse;
import com.maks.youtubedownloader.entity.User;
import com.maks.youtubedownloader.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public RegistrationSuccessResponse createNewUser(RegistrationRequest registrationRequest) {

        boolean emailExists = userRepository.existsByEmail(registrationRequest.getEmail());

        if (emailExists) {
            throw new UserAlreadyExistsException("Email already exists");
        }


            User user = new User();

            user.setEmail(registrationRequest.getEmail());
            user.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
            user.setFirstName(registrationRequest.getFirstName());
            user.setLastName(registrationRequest.getLastName());
            userRepository.save(user);
            return new RegistrationSuccessResponse("Registration Successful");

    }
}

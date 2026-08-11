package com.maks.youtubedownloader.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationRequest {
    @Size(min = 1, max = 50)
    @NotNull
    private String firstName;

    @Size(max = 50)
    private String lastName;

    @Email
    @NotNull
    private String email;

    @NotNull
    @Size(min = 1, max = 50)
    private String password;


}

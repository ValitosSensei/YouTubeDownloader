package com.maks.youtubedownloader.dto.request;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationRequest {
    @Size(min = 1, max = 50)
    @NotBlank
    private String firstName;

    @Size( max = 50)
    private String lastName;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Size(min = 8, max = 50)
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=\\S+$).*$",
    message = "Пароль повинен містити принаймні одну велику літеру, одну цифру та не повинен містити пробілів"
    )
    private String password;


}

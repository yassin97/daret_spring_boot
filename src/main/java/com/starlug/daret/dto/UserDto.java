package com.starlug.daret.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto
{
    private Long id;

    @NotEmpty(message = "Le prénom ne doit pas être vide")
    private String firstName;

    @NotEmpty(message = "Le nom ne doit pas être vide")
    private String lastName;

    @NotEmpty(message = "L'email ne doit pas être vide") @Email
    private String email;

    @NotEmpty(message = "Le mot de passe ne doit pas être vide")
    private String password;
}

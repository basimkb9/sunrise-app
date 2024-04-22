package com.sunrise.sunriseapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sunrise.sunriseapp.model.Roles;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Set;

@Data
@Builder
@ToString
public class UserDto {
    private long id;

    @NotBlank(message = "First Name should not be empty")
    private String firstName;

    @NotBlank(message = "Last Name should not be empty")
    private String lastName;

    @NotBlank(message = "Phone number is required")
    @Size(min = 11, max = 15, message = "Phone number should be valid, between 11-15 characters")
    private String phone;

    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 8, max = 32, message = "Password should be minimum 8 characters upto 32 characters")
    private String password;

    @NotNull
    private Roles role;
}

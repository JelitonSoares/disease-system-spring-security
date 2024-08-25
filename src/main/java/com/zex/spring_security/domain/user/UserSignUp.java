package com.zex.spring_security.domain.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserSignUp(@NotBlank
                         @Email
                         String login,
                         @NotBlank
                         String password,
                         @NotNull
                         UserRole role) {
}

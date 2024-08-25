package com.zex.spring_security.domain.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserLogin(@NotBlank
                        @Email
                        String login,
                        @NotBlank
                        String password) {
}

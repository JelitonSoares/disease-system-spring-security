package com.zex.spring_security.domain.user;

public enum UserRole {
    USER("user"),
    ADMIN("admin");

    private String role;

    UserRole(String role) {
        this.role = role;
    }
}

package com.zex.spring_security.controllers;

import com.zex.spring_security.domain.user.UserLogin;
import com.zex.spring_security.services.SecurityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class SecurityController {
    @Autowired
    private SecurityService service;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid UserLogin data) {
        return ResponseEntity.ok().build();
    }
}

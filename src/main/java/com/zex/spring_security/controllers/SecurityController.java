package com.zex.spring_security.controllers;

import com.zex.spring_security.domain.user.User;
import com.zex.spring_security.domain.user.UserLogin;
import com.zex.spring_security.domain.user.UserSignUp;
import com.zex.spring_security.infra.token.TokenDTO;
import com.zex.spring_security.infra.token.TokenService;
import com.zex.spring_security.repositories.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class SecurityController {
    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private BCryptPasswordEncoder encoder;
    @Autowired
    private UserRepository repository;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid UserLogin data) {

        UsernamePasswordAuthenticationToken securityToken =
                new UsernamePasswordAuthenticationToken(data.login(), data.password());

        Authentication authenticate = manager.authenticate(securityToken);


        String tokenJWT = tokenService.generateToken((User) authenticate.getPrincipal());


        return ResponseEntity.ok(new TokenDTO(tokenJWT));
    }


    @PostMapping("/signup")
    @Transactional
    public ResponseEntity signUp(@RequestBody @Valid UserSignUp data) {
        String encryptedPassword = encoder.encode(data.password());
        User newUser = new User(data.login(), encryptedPassword, data.role());

        this.repository.save(newUser);

        return ResponseEntity.ok().build();
    }
 }

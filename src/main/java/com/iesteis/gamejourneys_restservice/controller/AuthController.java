package com.iesteis.gamejourneys_restservice.controller;

import com.iesteis.gamejourneys_restservice.model.dto.AuthCredentialsRequest;
import com.iesteis.gamejourneys_restservice.model.entity.User;
import com.iesteis.gamejourneys_restservice.util.JwtUtil;
import com.iesteis.gamejourneys_restservice.util.UserViewUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }


    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(originPatterns = "http://localhost:*", allowedHeaders = {HttpHeaders.AUTHORIZATION})
    public ResponseEntity<?> login(@RequestBody AuthCredentialsRequest req) {
        try {
            Authentication authenticate = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            req.getUsername(),
                            req.getPassword()
                    )
            );

            User user = (User) authenticate.getPrincipal();

            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.add(HttpHeaders.AUTHORIZATION, jwtUtil.generateToken(user));
            responseHeaders.add(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, HttpHeaders.AUTHORIZATION);

            return ResponseEntity.ok()
                    .headers(responseHeaders)
                    .body(UserViewUtil.userToView(user));

        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}

package com.iesteis.gamejourneys_restservice.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Encoder {

    PasswordEncoder encoder = new BCryptPasswordEncoder();

    public PasswordEncoder getEncoder() {
        return encoder;
    }

}

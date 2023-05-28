package com.iesteis.gamejourneys_restservice.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthCredentialsRequest {

    private String username;
    private String password;

}

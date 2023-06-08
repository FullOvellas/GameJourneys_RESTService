package com.iesteis.gamejourneys_restservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class UserView {

    private long id;
    private String username;

    public UserView(long id, String username) {
        this.id = id;
        this.username = username;
    }
}

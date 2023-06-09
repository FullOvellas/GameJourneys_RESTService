package com.iesteis.gamejourneys_restservice.model.dto;

import java.util.Objects;

public class UserView {

    private long id;
    private String username;

    public UserView(long id, String username) {
        this.id = id;
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserView userView = (UserView) o;
        return id == userView.id && Objects.equals(username, userView.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username);
    }
}

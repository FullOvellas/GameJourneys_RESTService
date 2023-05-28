package com.iesteis.gamejourneys_restservice.util;

import com.iesteis.gamejourneys_restservice.model.dto.UserView;
import com.iesteis.gamejourneys_restservice.model.entity.User;

public class UserViewUtil {

    public static UserView userToView(User user) {
        return new UserView(user.getId(), user.getUsername());
    }

}

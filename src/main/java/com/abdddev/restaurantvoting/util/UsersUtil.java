package com.abdddev.restaurantvoting.util;

import com.abdddev.restaurantvoting.model.Role;
import com.abdddev.restaurantvoting.model.User;
import com.abdddev.restaurantvoting.to.UserTo;
import lombok.experimental.UtilityClass;

import static com.abdddev.restaurantvoting.config.WebSecurityConfig.PASSWORD_ENCODER;

@UtilityClass
public class UsersUtil {
    public static User createNewFromTo(UserTo userTo) {
        return new User(null, userTo.getName(), userTo.getEmail().toLowerCase(), userTo.getPassword(), Role.USER);
    }

    public static User updateFromTo(User user, UserTo userTo) {
        user.setName(userTo.getName());
        user.setEmail(userTo.getEmail().toLowerCase());
        user.setPassword(userTo.getPassword());
        return user;
    }

    public static User prepareToSave(User user) {
        user.setPassword(PASSWORD_ENCODER.encode(user.getPassword()));
        user.setEmail(user.getEmail().toLowerCase());
        return user;
    }
}
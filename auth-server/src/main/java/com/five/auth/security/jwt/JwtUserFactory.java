package com.five.auth.security.jwt;

import com.five.auth.model.User;

/**
 * Implementation of Factory Method for class {@link JwtUser}.
 *
 * @author Bohdan
 * @version 1.0
 */

public final class JwtUserFactory {

    public JwtUserFactory() {
        // object creates with builder pattern
    }

    public static JwtUser create(User user) {
        return new JwtUser(
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword(),
                user.getRole().getAuthorities()
        );
    }

}

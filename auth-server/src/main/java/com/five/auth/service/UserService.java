package com.five.auth.service;

import com.five.auth.model.authorities.Role;
import com.five.auth.model.User;

public interface UserService {

    User register(User user, Role role);

    User findByEmail(String email);

}

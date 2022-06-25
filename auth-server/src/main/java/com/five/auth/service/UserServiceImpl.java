package com.five.auth.service;

import com.five.auth.exception.UserAlreadyRegisteredException;
import com.five.auth.model.authorities.Role;
import com.five.auth.model.User;
import com.five.auth.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final BCryptPasswordEncoder encoder;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(BCryptPasswordEncoder encoder, UserRepository userRepository) {
        this.encoder = encoder;
        this.userRepository = userRepository;
    }

    @Override
    public User register(User user, Role role) {
        userRepository.findByEmail(user.getEmail())
                .ifPresent(repoUser -> {
                    throw new UserAlreadyRegisteredException("Email " + user.getEmail() + " is already registered");
                });

        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole(role);

        User registeredUser = userRepository.save(user);

        log.info("IN register - user: {} successfully registered", registeredUser);

        return registeredUser;
    }

    @Override
    public User findByEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new NoSuchElementException("No user with email " + email));
        log.info("IN findByUsername - user: {} found by email: {}", user, email);
        return user;
    }
}

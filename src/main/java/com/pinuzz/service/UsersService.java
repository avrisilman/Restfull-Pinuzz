package com.pinuzz.service;

import com.pinuzz.jpa.Users;
import org.springframework.security.core.userdetails.User;
import java.util.Optional;

public interface UsersService {
    String login(String username);
    Optional<User> findByToken(String token);
    Users save(Users user);
}


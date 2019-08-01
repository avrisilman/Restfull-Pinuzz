package com.pinuzz.service.impl;

import com.pinuzz.jpa.Users;
import com.pinuzz.repositories.UsersRepository;
import com.pinuzz.service.UsersService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service("cusersService")
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersRepository usersRepository;


    @Override
    public String login(String username) {
        Optional<Users> users = usersRepository.login(username);
        if(users.isPresent()){
            String token = UUID.randomUUID().toString();
            Users custom= users.get();
            custom.setToken(token);
            usersRepository.save(custom);
            return token;
        }

        return StringUtils.EMPTY;
    }

    @Override
    public Optional<User> findByToken(String token) {
        Optional<Users> users= usersRepository.findByToken(token);
        if(users.isPresent()){
            Users customer1 = users.get();
            User user= new User(customer1.getHandphone(), customer1.getEmail(), true, true, true, true,
                    AuthorityUtils.createAuthorityList("USER"));
            return Optional.of(user);
        }
        return  Optional.empty();
    }

    @Override
    public Users save(Users user) {
            String token = UUID.randomUUID().toString();
            Users newUser = new Users();
            newUser.setFullName(user.getFullName());
            newUser.setHandphone(user.getHandphone());
            newUser.setEmail(user.getEmail());
            newUser.setToken(token);
            return  usersRepository.save(newUser);
    }

}


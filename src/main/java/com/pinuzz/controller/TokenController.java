package com.pinuzz.controller;

import com.pinuzz.jpa.ApiResponse;
import com.pinuzz.jpa.Users;
import com.pinuzz.service.UsersService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class TokenController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/signin")
    public String getToken(@RequestParam("handphone") final String handphone){
        String token= usersService.login(handphone);
        if(StringUtils.isEmpty(token)){
            return "no token found";
        }
        return token;
    }


    @PostMapping("/signup")
    public ApiResponse<Users> saveUser(@RequestBody Users user){
        return new ApiResponse<>(HttpStatus.OK.value(), "success.", usersService.save(user));
    }

}


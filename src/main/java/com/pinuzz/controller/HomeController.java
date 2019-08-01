package com.pinuzz.controller;

import com.pinuzz.jpa.ApiResponse;
import com.pinuzz.jpa.Categories;
import com.pinuzz.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private HomeService homeService;

    @GetMapping(value = "/api/home")
    public String home(){
       return "TESTING HOMES ";
    }

    @GetMapping(value = "/api/category")
    public ApiResponse<List<Categories>> listCategories(){
        return new ApiResponse<>(HttpStatus.OK.value(), "success", homeService.findAll());
    }

    @GetMapping(value = "/api/category/{id}")
    public ApiResponse<Categories> getId(@PathVariable long id){
        return new ApiResponse<>(HttpStatus.OK.value(), "success",homeService.findById(id));
    }

}


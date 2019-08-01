package com.pinuzz.service;

import com.pinuzz.jpa.Categories;

import java.util.List;

public interface HomeService {
    List<Categories> findAll();
    Categories findById(long id);
}

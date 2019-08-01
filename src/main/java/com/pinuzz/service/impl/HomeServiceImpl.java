package com.pinuzz.service.impl;

import com.pinuzz.jpa.Categories;
import com.pinuzz.repositories.HomeRepository;
import com.pinuzz.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("homeService")
public class HomeServiceImpl implements HomeService {

    @Autowired
    HomeRepository homeRepository;

    @Override
    public List<Categories> findAll() {
        List<Categories> list = new ArrayList<>();
        homeRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Categories findById(long id) {
        Optional<Categories> optionalUser = homeRepository.findById(id);
        return optionalUser.isPresent() ? optionalUser.get() : null;
    }
}

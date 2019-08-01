package com.pinuzz.repositories;

import com.pinuzz.jpa.Categories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeRepository extends CrudRepository<Categories, Long> {

}
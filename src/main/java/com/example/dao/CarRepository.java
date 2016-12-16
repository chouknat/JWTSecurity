package com.example.dao;

import com.example.model.Car;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by a576097 on 07/12/2016.
 */
public interface CarRepository extends CrudRepository<Car, Long> {
}

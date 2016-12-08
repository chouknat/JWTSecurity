package com.example.dao;

import com.example.model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by a576097 on 07/12/2016.
 */
@RepositoryRestResource(path = "test")
public interface CarRepository extends CrudRepository<Car, Long> {
}

package com.example.services;

import com.example.model.Car;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by a576097 on 16/08/2016.
 */

public interface CarService {

    Iterable<Car> getAllCars();

    void createCar(Car car);

}

package com.example.services.Impl;

import com.example.dao.CarRepository;
import com.example.model.Car;
import com.example.services.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * Created by a576097 on 16/08/2016.
 */
@Service
@Profile("prod")
@Slf4j
public class CarServiceImpl implements CarService{

    @Autowired
    CarRepository carRepository;

    @Override
    public Iterable<Car> getAllCars() {
        Iterable<Car> carList = carRepository.findAll();
        return carList;
    }

    @Override
    public void createCar(Car car) {
        log.info("Creating a car : " , car.toString());
        carRepository.save(car);
    }
}

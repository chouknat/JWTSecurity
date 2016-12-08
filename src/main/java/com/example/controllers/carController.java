package com.example.controllers;

import com.example.model.Car;
import com.example.services.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by a576097 on 16/08/2016.
 */

@RestController
@RequestMapping(value = "/api/cars")
@Slf4j
public class carController {

    @Autowired
    CarService carService;

    @RequestMapping(value = "/allCars", method = RequestMethod.GET)
    ResponseEntity<Iterable<Car>> getAllCars() {

        log.info("List of car all cars");
        Iterable<Car> carList = carService.getAllCars();
        return new ResponseEntity<>(carList, HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    void createCar(@RequestBody Car car) {
        carService.createCar(car);
    }
 }

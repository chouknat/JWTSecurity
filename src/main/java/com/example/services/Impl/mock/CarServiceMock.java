package com.example.services.Impl.mock;

import com.example.model.Car;
import com.example.services.CarService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a576097 on 16/08/2016.
 */
@Service
@Profile("dev")
public class CarServiceMock implements CarService {
    @Override
    public List<Car> getAllCars() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car(1, "Audi", 200, "A3"));
        carList.add(new Car(2, "Renault", 100, "Megane"));
        return carList;
    }

    @Override
    public void createCar(Car car) {

    }
}

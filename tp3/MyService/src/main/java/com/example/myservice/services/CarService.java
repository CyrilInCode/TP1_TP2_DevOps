package com.example.myservice.services;

import com.example.myservice.entities.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private List<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
    }

    public Car getCarByPlateNumber(String plateNumber) {
        return cars.stream()
                .filter(c -> c.getPlateNumber().equals(plateNumber))
                .findFirst()
                .orElse(null);
    }

    public void clear() {
        cars.clear();
    }
}

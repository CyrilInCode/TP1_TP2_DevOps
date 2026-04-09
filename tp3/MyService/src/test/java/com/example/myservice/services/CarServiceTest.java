package com.example.myservice.services;

import com.example.myservice.entities.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarServiceTest {

    private CarService carService;

    @BeforeEach
    public void setUp() {
        carService = new CarService();
    }

    @Test
    public void testAddCar() {
        Car car = new Car("ABC123", "Toyota", 15000.0);
        carService.addCar(car);
        assertEquals(1, carService.getCars().size());
    }

    @Test
    public void testGetCars() {
        carService.addCar(new Car("ABC123", "Toyota", 15000.0));
        carService.addCar(new Car("DEF456", "Renault", 12000.0));
        assertEquals(2, carService.getCars().size());
    }

    @Test
    public void testGetCarByPlateNumber() {
        Car car = new Car("ABC123", "Toyota", 15000.0);
        carService.addCar(car);
        Car found = carService.getCarByPlateNumber("ABC123");
        assertNotNull(found);
        assertEquals("Toyota", found.getBrand());
    }

    @Test
    public void testGetCarByPlateNumberNotFound() {
        Car found = carService.getCarByPlateNumber("UNKNOWN");
        assertNull(found);
    }
}

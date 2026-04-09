package com.example.myservice.controllers;

import com.example.myservice.entities.Car;
import com.example.myservice.services.CarService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RentServiceRestTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CarService carService;

    @BeforeEach
    public void setUp() {
        carService.clear();
    }

    @Test
    @Order(1)
    public void testAddCar() throws Exception {
        Car car = new Car("ABC123", "Toyota", 15000.0);
        ObjectMapper objectMapper = new ObjectMapper();

        mockMvc.perform(post("/cars")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(car)))
                .andExpect(status().isOk());
    }

    @Test
    @Order(2)
    public void testGetCars() throws Exception {
        carService.addCar(new Car("ABC123", "Toyota", 15000.0));

        mockMvc.perform(get("/cars"))
                .andExpect(status().isOk());
    }

    @Test
    @Order(3)
    public void testGetCarByPlateNumber() throws Exception {
        carService.addCar(new Car("ABC123", "Toyota", 15000.0));

        mockMvc.perform(get("/cars/ABC123"))
                .andExpect(status().isOk());
    }
}

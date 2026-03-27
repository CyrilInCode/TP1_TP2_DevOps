package com.example.myservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarServiceRest {

    @GetMapping("/cars")
    public List<String> getCars() {
        return List.of("Toyota", "Renault", "Peugeot");
    }

}

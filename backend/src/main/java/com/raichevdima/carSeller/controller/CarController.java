package com.raichevdima.carSeller.controller;

import com.raichevdima.carSeller.dto.CarDto;
import com.raichevdima.carSeller.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Dzmitry Raichau
 */
@RestController
@RequestMapping("/car")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(final CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/create")
    public String createCar(@RequestBody final CarDto carDto) {
        carService.createCar(carDto);
        return "Car created";
    }

    @GetMapping("/list")
    public List<CarDto> getAllCars() {
        return carService.getCarsList();
    }
}

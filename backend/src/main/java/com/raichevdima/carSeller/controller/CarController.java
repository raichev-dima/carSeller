package com.raichevdima.carSeller.controller;

import com.raichevdima.carSeller.dto.CarDto;
import com.raichevdima.carSeller.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Dzmitry Raichau
 */
@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(final CarService carService) {
        this.carService = carService;
    }

    @PostMapping()
    public ResponseEntity<Object> createCar(@RequestBody final CarDto carDto) {
        return carService.createCar(carDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCar(@RequestBody final CarDto carDto, @PathVariable long id) {
        return carService.updateCar(carDto, id);
    }

    @GetMapping("/{id}")
    public CarDto retrieveCar(@PathVariable long id) {
        return carService.retrieveCar(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable long id) {
        carService.deleteCar(id);
    }

    @GetMapping()
    public List<CarDto> getAllCars() {
        return carService.getCarsList();
    }
}

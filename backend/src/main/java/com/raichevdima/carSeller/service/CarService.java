package com.raichevdima.carSeller.service;

import com.raichevdima.carSeller.converter.CarConverter;
import com.raichevdima.carSeller.dto.CarDto;
import com.raichevdima.carSeller.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Dzmitry Raichau
 */
@Service
public class CarService {

    private final CarRepository carRepository;
    private final CarConverter carConverter;

    @Autowired
    public CarService(final CarRepository carRepository, final CarConverter carConverter) {
        this.carRepository = carRepository;
        this.carConverter = carConverter;
    }

    public void createCar(final CarDto carDto) {
        carRepository.save(carConverter.convertToDbo(carDto));
    }

    public List<CarDto> getCarsList() {
        return carRepository.findAll().stream().map(carConverter::convertToDto).collect(Collectors.toList());
    }
}

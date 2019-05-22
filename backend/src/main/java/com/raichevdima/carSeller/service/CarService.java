package com.raichevdima.carSeller.service;

import com.raichevdima.carSeller.converter.CarConverter;
import com.raichevdima.carSeller.dbo.CarDbo;
import com.raichevdima.carSeller.dto.CarDto;
import com.raichevdima.carSeller.exception.CarNotFoundException;
import com.raichevdima.carSeller.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
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

    public ResponseEntity<Object> createCar(final CarDto carDto) {

        CarDbo savedCar = carRepository.save(carConverter.convertToDbo(carDto));

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedCar.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    public CarDto retrieveCar(long id) {
        Optional<CarDbo> car = carRepository.findById(id);

        if (!car.isPresent()) {
            throw new CarNotFoundException("id-" + id);
        }

        return carConverter.convertToDto(car.get());
    }

    public ResponseEntity<Object> updateCar(final CarDto carDto, long id) {
        Optional<CarDbo> carOptional = carRepository.findById(id);

        if (!carOptional.isPresent())
            return ResponseEntity.notFound().build();

        carDto.setId(id);

        carRepository.save(carConverter.convertToDbo(carDto));

        return ResponseEntity.noContent().build();
    }

    public void deleteCar(long id) {
        carRepository.deleteById(id);
    }

    public List<CarDto> getCarsList() {
        return carRepository.findAll().stream().map(carConverter::convertToDto).collect(Collectors.toList());
    }
}

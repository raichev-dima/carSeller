package com.raichevdima.carSeller.service;

import com.raichevdima.carSeller.MockData;
import com.raichevdima.carSeller.converter.CarConverter;
import com.raichevdima.carSeller.dbo.CarDbo;
import com.raichevdima.carSeller.dto.CarDto;
import com.raichevdima.carSeller.repository.CarRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * @author Dzmitry Raichau
 */
@RunWith(MockitoJUnitRunner.class)
public class CarServiceTest {
    @InjectMocks
    private CarService carService;

    @Mock
    private CarRepository carRepository;
    @Spy
    private CarConverter carConverter;

    @Test
    public void createCar() {
        final CarDbo carDbo = new CarDbo();
        carDbo.setBrand("peugeout");
        carDbo.setModel("106");

        doReturn(carDbo).when(carRepository).save(any(CarDbo.class));

        carService.createCar(new CarDto());

        verify(carRepository, times(1)).save(any(CarDbo.class));

    }

    @Test
    public void getCarsList() {
        final List<CarDbo> findAllResult = new ArrayList<>();
        final CarDbo carDbo = MockData.carDbo();
        findAllResult.add(carDbo);
        findAllResult.add(carDbo);
        doReturn(findAllResult).when(carRepository).findAll();

        final List<CarDto> carsList = carService.getCarsList();

        verify(carRepository, times(1)).findAll();
        assertEquals(findAllResult.size(), carsList.size());
        for (final CarDto carDto : carsList) {
            assertEquals(carDbo.getBrand(), carDto.getBrand());
            assertEquals(carDbo.getBrand(), carDto.getModel());
        }

    }
}
package com.raichevdima.carSeller.converter;

import com.raichevdima.carSeller.MockData;
import com.raichevdima.carSeller.dbo.CarDbo;
import com.raichevdima.carSeller.dto.CarDto;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Dzmitry Raichau
 */
public class CarConverterTest {

    private final CarConverter carConverter = new CarConverter();

    @Test
    public void convertToDto() {
        final CarDbo carDbo = MockData.carDbo();
        final CarDto carDto = carConverter.convertToDto(carDbo);

        assertEquals(carDbo.getBrand(), carDto.getBrand());
        assertEquals(carDbo.getModel(), carDto.getModel());
        assertEquals(carDbo.getYearOfIssue(), carDto.getYearOfIssue());
        assertEquals(carDbo.getPrice(), carDto.getPrice());
        assertEquals(carDbo.getCurrency(), carDto.getCurrency());
    }

    @Test
    public void convertToDbo() {
        final CarDto carDto = MockData.carDto();
        final CarDbo carDbo = carConverter.convertToDbo(carDto);

        assertEquals(carDto.getBrand(), carDbo.getBrand());
        assertEquals(carDto.getModel(), carDbo.getModel());
        assertEquals(carDto.getYearOfIssue(), carDbo.getYearOfIssue());
        assertEquals(carDto.getPrice(), carDbo.getPrice());
        assertEquals(carDto.getCurrency(), carDbo.getCurrency());
    }
}
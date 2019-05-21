package com.raichevdima.carSeller;

import com.raichevdima.carSeller.dbo.CarDbo;
import com.raichevdima.carSeller.dto.CarDto;

/**
 * @author Dzmitry Raichau
 */
public class MockData {

    public static CarDbo carDbo() {
        final CarDbo carDbo = new CarDbo();

        carDbo.setBrand("peugeot");
        carDbo.setModel("106");
        carDbo.setYearOfIssue(1993);
        carDbo.setPrice("USD 1");

        return carDbo;
    }

    public static CarDto carDto() {
        final CarDto carDto = new CarDto();

        carDto.setBrand("peugeot");
        carDto.setModel("106");
        carDto.setYearOfIssue(1993);
        carDto.setPrice("USD 1");

        return carDto;
    }
}

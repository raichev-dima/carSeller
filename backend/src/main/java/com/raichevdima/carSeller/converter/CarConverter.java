package com.raichevdima.carSeller.converter;

import com.raichevdima.carSeller.dbo.CarDbo;
import com.raichevdima.carSeller.dto.CarDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * @author Dzmitry Raichau
 */
@Service
public class CarConverter implements DtoDboConverter<CarDto, CarDbo> {

    @Override
    public CarDto convertToDto(final CarDbo dbo) {
        final CarDto carDto = new CarDto();

        BeanUtils.copyProperties(dbo, carDto);

        return carDto;
    }

    @Override
    public CarDbo convertToDbo(final CarDto dto) {
        final CarDbo carDbo = new CarDbo();

        BeanUtils.copyProperties(dto, carDbo);

        return carDbo;
    }
}

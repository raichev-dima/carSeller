package com.raichevdima.carSeller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Dzmitry Raichau
 */
@Data
@NoArgsConstructor
public class CarDto {
    private Long id;
    private String brand;
    private String model;
    private Integer yearOfIssue;
    private String price;
}

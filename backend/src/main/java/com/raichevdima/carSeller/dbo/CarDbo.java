package com.raichevdima.carSeller.dbo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author Dzmitry Raichau
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "CARS")
public class CarDbo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "BRAND")
    @NotNull
    private String brand;

    @Column(name = "MODEL")
    @NotNull
    private String model;

    @Column(name = "YEAR_OF_ISSUE")
    @NotNull
    private Integer yearOfIssue;

    @Column(name = "PRICE")
    @NotNull
    private Double price;

    @Column(name = "CURRENCY")
    @NotNull
    private String currency;
}

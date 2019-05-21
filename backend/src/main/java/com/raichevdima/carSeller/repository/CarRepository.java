package com.raichevdima.carSeller.repository;

import com.raichevdima.carSeller.dbo.CarDbo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Dzmitry Raichau
 */
public interface CarRepository extends JpaRepository<CarDbo, Long> {
}

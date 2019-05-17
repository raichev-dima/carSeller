package com.raichevdima.carSeller.repository;

import com.raichevdima.carSeller.dbo.PersonDbo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Wladimir Litvinov
 */
public interface PersonRepository extends JpaRepository<PersonDbo, Long> {
}

package com.raichevdima.carSeller.service;

import com.raichevdima.carSeller.converter.PersonConverter;
import com.raichevdima.carSeller.dto.PersonDto;
import com.raichevdima.carSeller.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Wladimir Litvinov
 */
@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonConverter personConverter;

    @Autowired
    public PersonService(final PersonRepository personRepository, final PersonConverter personConverter) {
        this.personRepository = personRepository;
        this.personConverter = personConverter;
    }

    public void createPerson(final PersonDto personDto) {
        personRepository.save(personConverter.convertToDbo(personDto));
    }

    public List<PersonDto> getPersonsList() {
        return personRepository.findAll().stream().map(personConverter::convertToDto).collect(Collectors.toList());
    }
}

package com.raichevdima.carSeller.controller;

import com.raichevdima.carSeller.dto.PersonDto;
import com.raichevdima.carSeller.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Wladimir Litvinov
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(final PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/create")
    public String createPerson(@RequestBody final PersonDto personDto) {
        personService.createPerson(personDto);
        return "Person created";
    }

    @GetMapping("/list")
    public List<PersonDto> getAllPersons() {
        return personService.getPersonsList();
    }
}

package com.raichevdima.carSeller;

import com.raichevdima.carSeller.dbo.PersonDbo;
import com.raichevdima.carSeller.dto.PersonDto;

/**
 * @author Wladimir Litvinov
 */
public class MockData {

    public static PersonDbo personDbo() {
        final PersonDbo personDbo = new PersonDbo();
        personDbo.setFirstName("personDbo first name");
        personDbo.setLastName("personDbo last name");
        return personDbo;
    }

    public static PersonDto personDto() {
        final PersonDto personDto = new PersonDto();
        personDto.setFirstName("personDto first name");
        personDto.setLastName("personDto last name");
        return personDto;
    }
}

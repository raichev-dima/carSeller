package com.raichevdima.carSeller.converter;

import com.raichevdima.carSeller.MockData;
import com.raichevdima.carSeller.dbo.PersonDbo;
import com.raichevdima.carSeller.dto.PersonDto;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Wladimir Litvinov
 */
public class PersonConverterTest {

    private final PersonConverter personConverter = new PersonConverter();

    @Test
    public void convertToDto() {
        final PersonDbo personDbo = MockData.personDbo();
        final PersonDto personDto = personConverter.convertToDto(personDbo);
        assertEquals(personDbo.getFirstName(), personDto.getFirstName());
        assertEquals(personDbo.getLastName(), personDto.getLastName());
    }

    @Test
    public void convertToDbo() {
        final PersonDto personDto = MockData.personDto();
        final PersonDbo personDbo = personConverter.convertToDbo(personDto);
        assertEquals(personDto.getFirstName(), personDbo.getFirstName());
        assertEquals(personDto.getLastName(), personDbo.getLastName());
    }

}
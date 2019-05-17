package com.raichevdima.carSeller.converter;

/**
 * @author Wladimir Litvinov
 */
public interface DtoDboConverter<T, B> {
    T convertToDto(final B dbo);
    B convertToDbo(final T dto);
}

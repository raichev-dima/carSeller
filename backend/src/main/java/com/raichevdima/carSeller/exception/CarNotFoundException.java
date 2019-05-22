package com.raichevdima.carSeller.exception;

public class CarNotFoundException extends RuntimeException {

    public CarNotFoundException(String exception) {
        super(exception);
    }
}

package com.crud.library.controller;

public class LoanNotFoundException extends RuntimeException {
    public LoanNotFoundException() {
        super("The loan with the given id does not exist");
    }
}

package com.crud.library.exception;

public class LoanNotFoundException extends RuntimeException {
    public LoanNotFoundException() {
        super("The loan with the given id does not exist");
    }
}

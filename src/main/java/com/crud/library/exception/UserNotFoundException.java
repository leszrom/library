package com.crud.library.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("The user with the given id does not exist");
    }
}

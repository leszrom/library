package com.crud.library.controller;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("The user with the given id does not exist");
    }
}

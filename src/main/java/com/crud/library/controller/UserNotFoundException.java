package com.crud.library.controller;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(final String message) {
        super(message);
    }
}

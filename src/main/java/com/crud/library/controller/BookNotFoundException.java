package com.crud.library.controller;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException() {
        super("The book with the given id does not exist");
    }
}

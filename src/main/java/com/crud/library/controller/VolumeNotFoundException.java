package com.crud.library.controller;

public class VolumeNotFoundException extends RuntimeException {
    public VolumeNotFoundException() {
        super("The volume with the given id does not exist");
    }
}

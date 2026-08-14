package com.maks.youtubedownloader.configuration.exceptions;

public  class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
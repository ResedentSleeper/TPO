package edu.exceptions;

public class InvalidDriverException extends RuntimeException {

    protected String message;

    public InvalidDriverException() {
        message = "Invalid driver configuration. Please check your config file";
    }

    public String getMessage() {
        return message;
    }

}
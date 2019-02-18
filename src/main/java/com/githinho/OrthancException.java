package com.githinho;

public class OrthancException extends Exception {

    public OrthancException() {
    }

    public OrthancException(String message) {
        super(message);
    }

    public OrthancException(String message, Throwable cause) {
        super(message, cause);
    }

    public OrthancException(Throwable cause) {
        super(cause);
    }
}

package com.stackroute.muzixservice.exceptions;

public class TrackNotFoundException extends Throwable {

    private String message;
    public TrackNotFoundException()
    {

    }
    public TrackNotFoundException(String message)
    {
        super(message);
        this.message=message;
    }
}

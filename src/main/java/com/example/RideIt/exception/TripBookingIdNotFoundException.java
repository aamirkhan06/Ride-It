package com.example.RideIt.exception;

public class TripBookingIdNotFoundException extends RuntimeException
{
    public TripBookingIdNotFoundException(String message)
    {
        super(message);
    }
}

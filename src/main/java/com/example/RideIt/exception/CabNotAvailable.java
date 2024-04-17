package com.example.RideIt.exception;

public class CabNotAvailable extends RuntimeException
{
    public CabNotAvailable(String message)
    {
        super(message);
    }
}

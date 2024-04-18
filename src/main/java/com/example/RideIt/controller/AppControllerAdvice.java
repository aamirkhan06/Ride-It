package com.example.RideIt.controller;

import com.example.RideIt.dto.response.ExceptionResponse;
import com.example.RideIt.dto.response.Response;
import com.example.RideIt.dto.response.TripBookingResponse;
import com.example.RideIt.exception.CabNotAvailable;
import com.example.RideIt.exception.CustomerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AppControllerAdvice
{
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({CustomerNotFoundException.class,
            CabNotAvailable.class})
    public ResponseEntity<TripBookingResponse> handleException(RuntimeException e)
    {
        TripBookingResponse response=TripBookingResponse.builder()
                .message(e.getMessage())
                .build();
        return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

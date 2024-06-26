package com.example.RideIt.controller;

import com.example.RideIt.dto.request.TripBookingRequest;
import com.example.RideIt.dto.response.Response;
import com.example.RideIt.dto.response.TripBookingResponse;
import com.example.RideIt.model.TripBooking;
import com.example.RideIt.service.TripBookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/trip")
@RequiredArgsConstructor
public class TripBookingController
{
    private final TripBookingService tripBookingService;
    @PostMapping("/book")
    public ResponseEntity<TripBookingResponse> bookCab(@RequestParam(value = "apply-coupon",required = false,defaultValue = "false") boolean applyCoupon,
                                                 @RequestBody TripBookingRequest tripBookingRequest)
    {
        TripBookingResponse response= tripBookingService.bookCab(applyCoupon,tripBookingRequest);
        return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/{tripId}/cancel")
    public ResponseEntity<TripBookingResponse> cancleTrip(@PathVariable(value="tripId") String tripId)
    {
        TripBookingResponse response= tripBookingService.cancleTrip(tripId);
        return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/{tripId}/complete")
    public ResponseEntity<TripBookingResponse> completeTrip(@PathVariable(value="tripId") String tripId)
    {
        TripBookingResponse response= tripBookingService.completeTrip(tripId);
        return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

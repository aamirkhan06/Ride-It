package com.example.RideIt.transformer;

import com.example.RideIt.Enum.TripStatus;
import com.example.RideIt.dto.request.TripBookingRequest;
import com.example.RideIt.dto.response.DriverResponse;
import com.example.RideIt.dto.response.TripBookingResponse;
import com.example.RideIt.model.TripBooking;

import java.util.UUID;

public class BookingTransformer
{
    public static TripBooking bookingRequestToBooking(TripBookingRequest tripBookingRequest)
    {
        return TripBooking.builder()
                .bookingId(String.valueOf(UUID.randomUUID()))
                .pickUp(tripBookingRequest.getPickUp())
                .destination(tripBookingRequest.getDestination())
                .tripDistanceInKm(tripBookingRequest.getTripDistanceInKm())
                .tripStatus(TripStatus.IN_TRANSIT)
                .build();
    }

    public static TripBookingResponse bookingToBookingResponse(TripBooking tripBooking)
    {
        return TripBookingResponse.builder()
                .bookingId(tripBooking.getBookingId())
                .pickUp(tripBooking.getPickUp())
                .destination(tripBooking.getDestination())
                .tripDistanceInKm(tripBooking.getTripDistanceInKm())
                .totalFare(tripBooking.getTotalFare())
                .tripStatus(tripBooking.getTripStatus())
                .bookAt(tripBooking.getBookAt())
                .customerResponse(CustomerTransformer.customertoCustomerResponse(tripBooking.getCustomer()))
                .driverResponse(DriverTransformer.driverToDriverResponse(tripBooking.getDriver()))
                .build();
    }
}

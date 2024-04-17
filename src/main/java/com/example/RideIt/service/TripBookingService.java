package com.example.RideIt.service;

import com.example.RideIt.dto.request.TripBookingRequest;
import com.example.RideIt.dto.response.TripBookingResponse;
import com.example.RideIt.exception.CabNotAvailable;
import com.example.RideIt.exception.CustomerNotFoundException;
import com.example.RideIt.model.Cab;
import com.example.RideIt.model.Customer;
import com.example.RideIt.model.TripBooking;
import com.example.RideIt.repository.CabRepository;
import com.example.RideIt.repository.CustomerRepository;
import com.example.RideIt.repository.DriverRepository;
import com.example.RideIt.repository.TripBookingRepository;
import com.example.RideIt.transformer.BookingTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TripBookingService {

    private final CustomerRepository customerRepository;
    private final CabRepository cabRepository;
    private final DriverRepository driverRepository;
    private  final TripBookingRepository tripBookingRepository;
    public TripBookingResponse bookCab(boolean applyCoupon, TripBookingRequest tripBookingRequest)
    {
        //validate emailId of the customer
        Customer customer=customerRepository.findByEmail(tripBookingRequest.getCustomerEmail());
        if(customer==null)
        {
            throw new CustomerNotFoundException("Invalid Email Id");
        }
        System.out.println(customer.getEmail());
        //check if the cab is available or not
        //get a random available cab
        Cab cab=cabRepository.getRandomAvailableCab();
        if(cab==null)
        {
            throw new CabNotAvailable("Sorry! All the drivers are busy right now");
        }

        //now both customer and cab has been validated, now the booking will be done
        TripBooking tripBooking = BookingTransformer.bookingRequestToBooking(tripBookingRequest);
        tripBooking.setTotalFare(cab.getFarePerKm() * tripBookingRequest.getTripDistanceInKm());
        tripBooking.setCustomer(customer);
        tripBooking.setDriver(cab.getDriver());

        TripBooking savedTripBooking=tripBookingRepository.save(tripBooking); //will have a primary key

        customer.getBookings().add(savedTripBooking);

        cab.setAvailable(false);
        cab.getDriver().getBookings().add(savedTripBooking);

        customerRepository.save(customer); //save customer and savedBooking
        driverRepository.save(cab.getDriver()); //save driver, cab and savedBookings

        return BookingTransformer.bookingToBookingResponse(tripBooking);
    }
}

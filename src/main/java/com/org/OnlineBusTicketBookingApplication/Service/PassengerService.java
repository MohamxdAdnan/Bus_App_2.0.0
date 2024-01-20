package com.org.OnlineBusTicketBookingApplication.Service;

import com.org.OnlineBusTicketBookingApplication.Dto.PassengerDto;

import java.util.List;

public interface PassengerService {
    PassengerDto createPassenger (PassengerDto passengerDto);
    PassengerDto updatePassenger (PassengerDto passengerDto,Long passengerId);
    void deletePassenger (Long passengerId);
    PassengerDto getPassenger (Long passengerId);
    List<PassengerDto> getAllPassengers ();
}

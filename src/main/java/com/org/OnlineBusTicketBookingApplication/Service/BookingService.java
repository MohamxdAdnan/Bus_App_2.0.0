package com.org.OnlineBusTicketBookingApplication.Service;

import com.org.OnlineBusTicketBookingApplication.Dto.BookingDto;
import com.org.OnlineBusTicketBookingApplication.Dto.BusDto;

import java.util.List;

public interface BookingService {
    BookingDto createBooking (BookingDto bookingDto);
    BookingDto updateBooking (BookingDto bookingDto,Long bookingId);
    void deleteBooking (Long bookingId);
    BookingDto getBooking (Long bookingId);
    List<BookingDto> getAlBookings ();
}

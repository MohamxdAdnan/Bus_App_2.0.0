package com.org.OnlineBusTicketBookingApplication.Service.Impl;

import com.org.OnlineBusTicketBookingApplication.Dto.BookingDto;
import com.org.OnlineBusTicketBookingApplication.Entity.Booking;
import com.org.OnlineBusTicketBookingApplication.Repository.BookingRepository;
import com.org.OnlineBusTicketBookingApplication.Service.BookingService;
import com.org.OnlineBusTicketBookingApplication.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {
    private BookingRepository bookingRepository;
    private ModelMapper modelMapper;

    @Override
    public BookingDto createBooking(BookingDto bookingDto) {
        Booking booking = modelMapper.map(bookingDto, Booking.class);
        Booking newBooking = bookingRepository.save(booking);
        return modelMapper.map(newBooking, BookingDto.class);
    }

    @Override
    public BookingDto updateBooking(BookingDto bookingDto, Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id:" + bookingId));
        booking.setBusName(bookingDto.getBusName());
        booking.setDate(bookingDto.getDate());
        booking.setPrice(bookingDto.getPrice());
        booking.setFromDestination(bookingDto.getFromDestination());
        booking.setToDestination(bookingDto.getToDestination());
        booking.setTicketCount(bookingDto.getTicketCount());
        booking.setTime(bookingDto.getTime());
        booking.setTotalPrice(bookingDto.getTotalPrice());



        Booking newBooking = bookingRepository.save(booking);
        return modelMapper.map(newBooking,BookingDto.class);
    }

    @Override
    public void deleteBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id:" + bookingId));
        bookingRepository.delete(booking);
    }

    @Override
    public BookingDto getBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id:" + bookingId));
        return modelMapper.map(booking,BookingDto.class);
    }

    @Override
    public List<BookingDto> getAlBookings() {
        List<Booking> allBookings = bookingRepository.findAll();
        List<BookingDto> allBookingDtos = allBookings.stream()
                .map((booking)->modelMapper.map(booking, BookingDto.class)).collect(Collectors.toList());
        return allBookingDtos;
    }
}

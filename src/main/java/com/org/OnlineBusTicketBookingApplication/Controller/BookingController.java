package com.org.OnlineBusTicketBookingApplication.Controller;

import com.org.OnlineBusTicketBookingApplication.Dto.BookingDto;
import com.org.OnlineBusTicketBookingApplication.Service.BookingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "CRUD API's for Booking Resource"
)
@RestController
@AllArgsConstructor
@RequestMapping("/api/booking")
public class BookingController {
    private BookingService bookingService;

    @Operation(
            summary = "Create Booking Resource"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 Created"
    )
    @PostMapping("/create")
    public ResponseEntity<BookingDto> createBooking(@RequestBody BookingDto bookingDto) {
        BookingDto createdBooking = bookingService.createBooking(bookingDto);
        return new ResponseEntity<>(createdBooking, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get Booking Resource"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @GetMapping("{id}")
    public ResponseEntity<BookingDto> getBooking(@PathVariable Long bookingId) {
        BookingDto bookingDto = bookingService.getBooking(bookingId);
        return new ResponseEntity<>(bookingDto, HttpStatus.OK);
    }

    @Operation(
            summary = "Get All Booking Resource"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @GetMapping
    public ResponseEntity<List<BookingDto>> getAllBookings() {
        List<BookingDto> allBookings = bookingService.getAlBookings();
        return new ResponseEntity<>(allBookings, HttpStatus.OK);
    }

    @Operation(
            summary = "Delete Booking Resource"
    )
    @ApiResponse(
            responseCode = "204",
            description = "HTTP Status 204 No Content"
    )
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable Long bookingId) {
        bookingService.deleteBooking(bookingId);
        return new ResponseEntity<>("Booking deleted", HttpStatus.NO_CONTENT);
    }

    @Operation(
            summary = "Update Booking Resource"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @PutMapping("{id}")
    public ResponseEntity<BookingDto> updateBooking(@RequestBody BookingDto bookingDto, @PathVariable Long bookingId) {
        BookingDto updatedBooking = bookingService.updateBooking(bookingDto, bookingId);
        return new ResponseEntity<>(updatedBooking, HttpStatus.OK);
    }
}

package com.org.OnlineBusTicketBookingApplication.Dto;

import com.org.OnlineBusTicketBookingApplication.Entity.Passenger;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(
        description = "Booking DTO Model Info"
)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDto {

    private Long bookingId;
    @Schema(
            description = "Booking Date"
    )
    private String Date;
    @Schema(
            description = "To Destination"
    )
    private String toDestination;
    @Schema(
            description = "From Destination"
    )
    private String fromDestination;
    @Schema(
            description = "Price"
    )
    private Double price;
    @Schema(
            description = "Bus Name"
    )
    private String BusName;
    @Schema(
            description = "Time"
    )
    private String time;
    @Schema(
            description = "Ticket Count"
    )
    private int ticketCount;
    @Schema(
            description = "Total Price"
    )
    private Double totalPrice;

    private Passenger passenger;

}

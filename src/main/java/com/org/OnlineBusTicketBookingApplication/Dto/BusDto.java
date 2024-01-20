package com.org.OnlineBusTicketBookingApplication.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(
        description = "Bus DTO Model Info"
)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusDto {
    private Long busId;
    @Schema(
            description = "Bus Name"
    )
    private String busName;
    @Schema(
            description = "Price"
    )
    private Double price;
    @Schema(
            description = "Date"
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
            description = "Departure Time"
    )
    private String departureTime;
    private Long totalSeats;
    private Long availableSeats;

}

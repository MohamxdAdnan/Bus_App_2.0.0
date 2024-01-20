package com.org.OnlineBusTicketBookingApplication.Dto;

import com.org.OnlineBusTicketBookingApplication.Entity.Booking;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Schema(
        description = "Passenger DTO Model Info"
)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassengerDto {
    private Long passengerId;
    @Schema(
            description = "First Name"
    )
    private String firstName;
    @Schema(
            description = "Last Name"
    )
    private String lastName;
    @Schema(
            description = "Email"
    )
    private String email;
    @Schema(
            description = "Password"
    )
    private String password;
    @Schema(
            description = "Age"
    )
    private String age;
    @Schema(
            description = "Gender"
    )
    private String gender;

    private List<Booking> bookingHistory;
}

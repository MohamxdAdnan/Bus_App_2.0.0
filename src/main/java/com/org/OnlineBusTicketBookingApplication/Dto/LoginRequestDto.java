package com.org.OnlineBusTicketBookingApplication.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(
        description = "Login Request DTO Model Info"
)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDto {
    @Schema(
            description = "Email"
    )
    private String email;
    @Schema(
            description = "Password"
    )
    private String password;
}

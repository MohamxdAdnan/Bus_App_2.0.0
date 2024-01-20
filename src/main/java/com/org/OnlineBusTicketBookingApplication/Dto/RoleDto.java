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
        description = "Role DTO Model Info"
)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto {

    private Long id;
    @Schema(
            description = "Role Name"
    )
    private String name;

}

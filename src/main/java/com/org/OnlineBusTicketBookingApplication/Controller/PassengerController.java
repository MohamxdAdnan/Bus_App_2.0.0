package com.org.OnlineBusTicketBookingApplication.Controller;

import com.org.OnlineBusTicketBookingApplication.Dto.LoginRequestDto;
import com.org.OnlineBusTicketBookingApplication.Dto.PassengerDto;
import com.org.OnlineBusTicketBookingApplication.Service.PassengerService;
import com.org.OnlineBusTicketBookingApplication.Service.JwtUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.security.authorization.AuthorityAuthorizationManager.hasRole;

@Tag(
        name = "CRUD API's for Passenger Resource"
)
@RestController
@AllArgsConstructor
@RequestMapping("/api/passenger")
public class PassengerController {
    private PassengerService passengerService;
    private JwtUtil jwtUtil;
    private AuthenticationManager authenticationManager;


    @Operation(
            summary = "Login For Passenger"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto loginRequestDto){
        UsernamePasswordAuthenticationToken token = new
                UsernamePasswordAuthenticationToken(loginRequestDto.getEmail(),loginRequestDto.getPassword());
        authenticationManager.authenticate(token);
        String jwt = jwtUtil.generate(loginRequestDto.getEmail());

        return new ResponseEntity<>(jwt,HttpStatus.OK);
    }
    @Operation(
            summary = "Create Passenger Resource"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 Created"
    )
    @PostMapping("/create")
    public ResponseEntity<PassengerDto> createPassenger(@RequestBody PassengerDto passengerDto) {
        PassengerDto createdPassenger = passengerService.createPassenger(passengerDto);
        return new ResponseEntity<>(createdPassenger, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get Passenger Resource"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @GetMapping("{id}")
    public ResponseEntity<PassengerDto> getPassenger(@PathVariable Long passengerId) {
        PassengerDto passengerDto = passengerService.getPassenger(passengerId);
        return new ResponseEntity<>(passengerDto, HttpStatus.OK);
    }

    @Operation(
            summary = "Get All Passenger Resource"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<PassengerDto>> getAllPassengers() {
        List<PassengerDto> allPassengers = passengerService.getAllPassengers();
        return new ResponseEntity<>(allPassengers, HttpStatus.OK);
    }

    @Operation(
            summary = "Delete Passenger Resource"
    )
    @ApiResponse(
            responseCode = "204",
            description = "HTTP Status 204 No Content"
    )
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePassenger(@PathVariable Long passengerId) {
        passengerService.deletePassenger(passengerId);
        return new ResponseEntity<>("Passenger deleted", HttpStatus.NO_CONTENT);
    }

    @Operation(
            summary = "Update Passenger Resource"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @PutMapping("{id}")
    public ResponseEntity<PassengerDto> updatePassenger(@RequestBody PassengerDto passengerDto, @PathVariable Long passengerId) {
        PassengerDto updatedEmployee = passengerService.updatePassenger(passengerDto, passengerId);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }
}

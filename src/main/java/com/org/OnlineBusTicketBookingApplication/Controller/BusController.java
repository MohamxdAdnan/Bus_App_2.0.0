package com.org.OnlineBusTicketBookingApplication.Controller;

import com.org.OnlineBusTicketBookingApplication.Dto.BusDto;
import com.org.OnlineBusTicketBookingApplication.Service.BusService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "CRUD API's for Bus Resource"
)
@RestController
@AllArgsConstructor
@RequestMapping("/api/bus")
public class BusController {
    private BusService busService;

    @Operation(
            summary = "Create Bus Resource"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 Created"
    )
    @PostMapping("/create")
    public ResponseEntity<BusDto> createBus(@RequestBody BusDto busDto) {
        BusDto createdBus = busService.createBus(busDto);
        return new ResponseEntity<>(createdBus, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get Bus Resource"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @GetMapping("{id}")
    public ResponseEntity<BusDto> getBus(@PathVariable Long busId) {
        BusDto busDto = busService.getBus(busId);
        return new ResponseEntity<>(busDto, HttpStatus.OK);
    }

    @Operation(
            summary = "Get All Bus Resource"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @GetMapping
    public ResponseEntity<List<BusDto>> getAllBuses() {
        List<BusDto> allBuses = busService.getAllBuses();
        return new ResponseEntity<>(allBuses, HttpStatus.OK);
    }

    @Operation(
            summary = "Get All Bus Resource by From And To destination"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @GetMapping("{from}/{to}")
    public ResponseEntity<List<BusDto>> getBusesByFromAndTo(@PathVariable String fromDestination,@PathVariable String toDestination) {
        List<BusDto> buses = busService.getBusByFromAndTo(fromDestination,toDestination);
        return new ResponseEntity<>(buses, HttpStatus.OK);
    }

    @Operation(
            summary = "Delete Bus Resource"
    )
    @ApiResponse(
            responseCode = "204",
            description = "HTTP Status 204 No Content"
    )
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBus(@PathVariable Long busId) {
        busService.deleteBus(busId);
        return new ResponseEntity<>("Bus deleted", HttpStatus.NO_CONTENT);
    }

    @Operation(
            summary = "Update Bus Resource"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @PutMapping("{id}")
    public ResponseEntity<BusDto> updateBus(@RequestBody BusDto busDto, @PathVariable Long busId) {
        BusDto updatedBus = busService.updateBus(busDto, busId);
        return new ResponseEntity<>(updatedBus, HttpStatus.OK);
    }
}

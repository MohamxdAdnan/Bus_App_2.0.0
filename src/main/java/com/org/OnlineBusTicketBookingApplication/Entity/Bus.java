package com.org.OnlineBusTicketBookingApplication.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Bus")
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long busId;
    @Column(nullable = false)
    private String busName;
    @Column(nullable = false)
    private Double price;
    @Column(nullable = false)
    private String Date;
    @Column(nullable = false)
    private String toDestination;
    @Column(nullable = false)
    private String fromDestination;
    @Column(nullable = false)
    private String departureTime;
    @Column(nullable = false)
    private Long totalSeats;
    @Column(nullable = false)
    private Long availableSeats;

}

package com.org.OnlineBusTicketBookingApplication.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;
    @Column(nullable = false)
    private String Date;
    @Column(nullable = false)
    private String toDestination;
    @Column(nullable = false)
    private String fromDestination;
    @Column(nullable = false)
    private Double price;
    @Column(nullable = false)
    private String BusName;
    @Column(nullable = false)
    private String time;
    @Column(nullable = false)
    private int ticketCount;
    @Column(nullable = false)
    private Double totalPrice;

    @ManyToOne
    @JoinColumn(name="passenger_id")
    private Passenger passenger;
}

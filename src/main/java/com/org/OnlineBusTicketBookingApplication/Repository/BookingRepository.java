package com.org.OnlineBusTicketBookingApplication.Repository;

import com.org.OnlineBusTicketBookingApplication.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Long> {
}

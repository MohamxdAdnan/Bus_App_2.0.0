package com.org.OnlineBusTicketBookingApplication.Repository;

import com.org.OnlineBusTicketBookingApplication.Dto.BusDto;
import com.org.OnlineBusTicketBookingApplication.Entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusRepository extends JpaRepository<Bus,Long> {

    List<Bus> findByFromDestinationAndToDestination (String fromDestination, String toDestination);
}

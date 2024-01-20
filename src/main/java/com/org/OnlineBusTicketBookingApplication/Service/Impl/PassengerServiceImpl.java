package com.org.OnlineBusTicketBookingApplication.Service.Impl;

import com.org.OnlineBusTicketBookingApplication.Dto.PassengerDto;
import com.org.OnlineBusTicketBookingApplication.Entity.Passenger;
import com.org.OnlineBusTicketBookingApplication.Repository.PassengerRepository;
import com.org.OnlineBusTicketBookingApplication.Service.PassengerService;
import com.org.OnlineBusTicketBookingApplication.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PassengerServiceImpl implements PassengerService {
    private PassengerRepository passengerRepository;
    private ModelMapper modelMapper;

    @Override
    public PassengerDto createPassenger(PassengerDto passengerDto) {
        Passenger passenger = modelMapper.map(passengerDto, Passenger.class);
        Passenger newPassenger = passengerRepository.save(passenger);
        return modelMapper.map(newPassenger,PassengerDto.class);
    }

    @Override
    public PassengerDto updatePassenger(PassengerDto passengerDto, Long passengerId) {
        Passenger passenger = passengerRepository.findById(passengerId)
                .orElseThrow(() -> new ResourceNotFoundException("Passenger not found with id:" + passengerId));
        passenger.setFirstName(passengerDto.getFirstName());
        passenger.setLastName(passengerDto.getLastName());
        passenger.setAge(passengerDto.getAge());
        passenger.setGender(passengerDto.getGender());
        passenger.setEmail(passengerDto.getEmail());
        passenger.setPassword(passengerDto.getPassword());

        Passenger newPassenger = passengerRepository.save(passenger);
        return modelMapper.map(newPassenger,PassengerDto.class);
    }

    @Override
    public void deletePassenger(Long passengerId) {
        Passenger passenger = passengerRepository.findById(passengerId)
                .orElseThrow(() -> new ResourceNotFoundException("Passenger not found with id:" + passengerId));
        passengerRepository.delete(passenger);
    }

    @Override
    public PassengerDto getPassenger(Long passengerId) {
        Passenger passenger = passengerRepository.findById(passengerId)
                .orElseThrow(() -> new ResourceNotFoundException("Passenger not found with id:" + passengerId));

        return modelMapper.map(passenger,PassengerDto.class);
    }

    @Override
    public List<PassengerDto> getAllPassengers() {
        List<Passenger> allPassengers = passengerRepository.findAll();
        List<PassengerDto> allPassengerDtos = allPassengers.stream()
                .map((passenger)->modelMapper.map(passenger, PassengerDto.class)).collect(Collectors.toList());
        return allPassengerDtos;
    }
}

package com.org.OnlineBusTicketBookingApplication.Service;

import com.org.OnlineBusTicketBookingApplication.Entity.Passenger;
import com.org.OnlineBusTicketBookingApplication.Repository.PassengerRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PassengerUserDetailsService implements UserDetailsService {
    private PassengerRepository passengerRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Passenger passenger = passengerRepository.findByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException("Passenger not found with this email"));
       Set<GrantedAuthority> authorities= passenger.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
               .collect(Collectors.toSet());

        return new User(email, passenger.getPassword(), authorities);
    }

}

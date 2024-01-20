package com.org.OnlineBusTicketBookingApplication.Service;

import com.org.OnlineBusTicketBookingApplication.Entity.Passenger;
import com.org.OnlineBusTicketBookingApplication.Repository.PassengerRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PassengerAuthenticationManager implements AuthenticationManager {
    private PassengerRepository passengerRepository;
    private PasswordEncoder passwordEncoder;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        if(isValidUser(username,password)){
            return new UsernamePasswordAuthenticationToken(username,password);
        }else{
            throw new AuthenticationException("Invalid Credentials") {
            };
        }

    }

    private boolean isValidUser(String username, String password) {
        Passenger passenger = passengerRepository.findByEmail(username)
                .orElseThrow(()-> new UsernameNotFoundException("Passenger not found with this email"));

        boolean usernameValidation = passenger.getEmail().equals(username);
        boolean passwordValidation = passwordEncoder.matches(password,passenger.getPassword());

        return usernameValidation && passwordValidation;
    }
}

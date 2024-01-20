package com.org.OnlineBusTicketBookingApplication.Service;

import com.org.OnlineBusTicketBookingApplication.Entity.Passenger;
import com.org.OnlineBusTicketBookingApplication.Repository.PassengerRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {
    private JwtUtil jwtUtil;
    private PassengerRepository passengerRepository;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authorizationHeader = request.getHeader("Authorization");

        if(authorizationHeader == null || authorizationHeader.isEmpty()
        || !authorizationHeader.startsWith("Bearer")){
            filterChain.doFilter(request,response);
            return;
        }

        String token = authorizationHeader.split(" ")[1];
        if(!jwtUtil.validate(token)){
            filterChain.doFilter(request,response);
            return;
        }


        String email = jwtUtil.getUserName(token);
        Passenger passenger = passengerRepository.findByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException("Passenger not found with this email"));
        Set<GrantedAuthority> authorities= passenger.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toSet());

        UsernamePasswordAuthenticationToken _token = new
                UsernamePasswordAuthenticationToken(email,passenger.getPassword(),authorities);
        _token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));


        SecurityContextHolder.getContext().setAuthentication(_token);

        filterChain.doFilter(request,response);
    }
}

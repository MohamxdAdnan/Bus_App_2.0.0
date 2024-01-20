package com.org.OnlineBusTicketBookingApplication.Service;

import com.org.OnlineBusTicketBookingApplication.Dto.PassengerDto;
import com.org.OnlineBusTicketBookingApplication.Dto.RoleDto;

import java.util.List;

public interface RoleService {
    RoleDto createRole (RoleDto roleDto);
    RoleDto updateRole (RoleDto roleDto,Long roleId);
    void deleteRole (Long roleId);
    RoleDto getRole (Long roleId);
    List<RoleDto> getAllRoles ();
}

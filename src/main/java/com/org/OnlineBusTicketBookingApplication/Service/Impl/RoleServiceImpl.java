package com.org.OnlineBusTicketBookingApplication.Service.Impl;

import com.org.OnlineBusTicketBookingApplication.Dto.RoleDto;
import com.org.OnlineBusTicketBookingApplication.Entity.Role;
import com.org.OnlineBusTicketBookingApplication.Repository.RoleRepository;
import com.org.OnlineBusTicketBookingApplication.Service.RoleService;
import com.org.OnlineBusTicketBookingApplication.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;
    private ModelMapper modelMapper;

    @Override
    public RoleDto createRole(RoleDto roleDto) {
        Role role = modelMapper.map(roleDto, Role.class);
        Role newRole = roleRepository.save(role);
        return modelMapper.map(newRole, RoleDto.class);
    }

    @Override
    public RoleDto updateRole(RoleDto roleDto, Long roleId) {
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found with id:" + roleId));
        role.setName(roleDto.getName());


        Role newRole = roleRepository.save(role);
        return modelMapper.map(newRole,RoleDto.class);
    }

    @Override
    public void deleteRole(Long roleId) {
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found with id:" + roleId));
        roleRepository.delete(role);
    }

    @Override
    public RoleDto getRole(Long roleId) {
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found with id:" + roleId));
        return modelMapper.map(role,RoleDto.class);
    }

    @Override
    public List<RoleDto> getAllRoles() {
        List<Role> allRoles = roleRepository.findAll();
        List<RoleDto> allRoleDtos = allRoles.stream()
                .map((role)->modelMapper.map(role, RoleDto.class)).collect(Collectors.toList());
        return allRoleDtos;
    }
}

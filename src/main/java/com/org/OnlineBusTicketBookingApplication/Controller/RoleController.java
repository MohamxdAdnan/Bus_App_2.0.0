package com.org.OnlineBusTicketBookingApplication.Controller;

import com.org.OnlineBusTicketBookingApplication.Dto.RoleDto;
import com.org.OnlineBusTicketBookingApplication.Service.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "CRUD API's for Role Resource"
)
@RestController
@AllArgsConstructor
@RequestMapping("/api/role")
public class RoleController {
    private RoleService roleService;

    @Operation(
            summary = "Create Role Resource"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 Created"
    )
    @PostMapping("/create")
    public ResponseEntity<RoleDto> createRole(@RequestBody RoleDto roleDto) {
        RoleDto createdRole = roleService.createRole(roleDto);
        return new ResponseEntity<>(createdRole, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get Role Resource"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @GetMapping("{id}")
    public ResponseEntity<RoleDto> getRole(@PathVariable Long roleId) {
        RoleDto roleDto = roleService.getRole(roleId);
        return new ResponseEntity<>(roleDto, HttpStatus.OK);
    }

    @Operation(
            summary = "Get All Role Resource"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @GetMapping
    public ResponseEntity<List<RoleDto>> getAllRoles() {
        List<RoleDto> allRoles = roleService.getAllRoles();
        return new ResponseEntity<>(allRoles, HttpStatus.OK);
    }

    @Operation(
            summary = "Delete Role Resource"
    )
    @ApiResponse(
            responseCode = "204",
            description = "HTTP Status 204 No Content"
    )
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteRole(@PathVariable Long roleId) {
        roleService.deleteRole(roleId);
        return new ResponseEntity<>("Role deleted", HttpStatus.NO_CONTENT);
    }

    @Operation(
            summary = "Update Role Resource"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @PutMapping("{id}")
    public ResponseEntity<RoleDto> updateRole(@RequestBody RoleDto roleDto, @PathVariable Long roleId) {
        RoleDto updatedRole = roleService.updateRole(roleDto, roleId);
        return new ResponseEntity<>(updatedRole, HttpStatus.OK);
    }
}

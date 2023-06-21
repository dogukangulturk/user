package com.orcrist.user.controller;

import com.orcrist.user.dto.RoleDTO;
import com.orcrist.user.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public ResponseEntity<RoleDTO> addRole(@RequestBody RoleDTO roleDTO) {
        RoleDTO newRoleDTO = roleService.addRole(roleDTO);
        return ResponseEntity.ok(newRoleDTO);
    }

    @DeleteMapping("/{roleId}")
    public ResponseEntity<String> deleteRole(@PathVariable Long roleId) {
        roleService.deleteRole(roleId);
        return ResponseEntity.ok("Rol silindi");
    }

    @PutMapping("/{roleId}")
    public ResponseEntity<RoleDTO> updateRole(@PathVariable Long roleId, @RequestBody RoleDTO roleDTO) {
        RoleDTO updatedRoleDTO = roleService.updateRole(roleId, roleDTO);
        return ResponseEntity.ok(updatedRoleDTO);
    }

    @GetMapping
    public ResponseEntity<List<RoleDTO>> getAllRoles() {
        List<RoleDTO> roleDTOs = roleService.getAllRoles();
        return ResponseEntity.ok(roleDTOs);
    }
}
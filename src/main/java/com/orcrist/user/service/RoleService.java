package com.orcrist.user.service;

import com.orcrist.user.dto.RoleDTO;
import com.orcrist.user.model.Role;
import com.orcrist.user.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public RoleDTO addRole(RoleDTO roleDTO) {
        Role role = roleRepository.save(convertToRole(roleDTO));
        return convertToRoleDTO(role);
    }

    public void deleteRole(Long roleId) {
        roleRepository.deleteById(roleId);
    }

    public RoleDTO updateRole(Long roleId, RoleDTO roleDTO) {
        Role existingRole = roleRepository.findById(roleId).orElse(null);
        if (existingRole != null) {
            existingRole.setName(roleDTO.getName());
            Role updatedRole = roleRepository.save(existingRole);
            return convertToRoleDTO(updatedRole);
        }
        return null;
    }

    public List<RoleDTO> getAllRoles() {
        List<Role> roles = roleRepository.findAll();
        return convertToRoleDTOList(roles);
    }

    private Role convertToRole(RoleDTO roleDTO) {
        Role role = new Role();
        role.setName(roleDTO.getName());
        return role;
    }

    private RoleDTO convertToRoleDTO(Role role) {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setId(role.getId());
        roleDTO.setName(role.getName());
        return roleDTO;
    }

    private List<RoleDTO> convertToRoleDTOList(List<Role> roles) {
        List<RoleDTO> roleDTOs = new ArrayList<>();
        for (Role role : roles) {
            roleDTOs.add(convertToRoleDTO(role));
        }
        return roleDTOs;
    }
}


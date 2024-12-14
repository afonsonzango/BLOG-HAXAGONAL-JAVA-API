package com.blog.api.features.roles.application.ports.in;

import com.blog.api.features.roles.adapters.dtos.RoleRequestDTO;
import com.blog.api.features.roles.adapters.dtos.RoleResponseDTO;
import com.blog.api.features.roles.domain.Role;

import java.util.List;
import java.util.Optional;

public interface inRolePort {
    List<RoleResponseDTO>   getAllRoles();
    RoleResponseDTO         getRoleById(Long id);
    Optional<List<Role>>    getRoleByName(String name);
    RoleResponseDTO         createNewRole(RoleRequestDTO role);
    RoleResponseDTO         updateExistingRole(Long id, RoleRequestDTO roleRequestDTO);
    void                    deleteRoleById(Long id);
}
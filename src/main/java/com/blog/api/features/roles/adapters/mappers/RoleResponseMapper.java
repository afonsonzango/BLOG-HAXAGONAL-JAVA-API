package com.blog.api.features.roles.adapters.mappers;

import com.blog.api.features.roles.adapters.dtos.RoleResponseDTO;
import com.blog.api.features.roles.domain.Role;

public class RoleResponseMapper {
    public static RoleResponseDTO role_response_mapper (Role role) {
        RoleResponseDTO dto = new RoleResponseDTO();

        dto.setId(role.getId());
        dto.setUuid(role.getUuid());
        dto.setName(role.getName());
        dto.setUsers(role.getUsers());
        dto.setCreated_at(role.getCreated_at());
        dto.setUpdated_at(role.getUpdated_at());

        return dto;
    }
}

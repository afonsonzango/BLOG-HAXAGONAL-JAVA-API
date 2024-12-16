package com.blog.api.features.roles.adapters.mappers;

import com.blog.api.features.roles.adapters.dtos.RoleResponseDTO;
import com.blog.api.features.roles.domain.Role;
import com.blog.api.features.user.domain.User;

import java.util.List;
import java.util.Optional;

public class RoleResponseMapper {
    public static RoleResponseDTO role_response_mapper (Role role, Optional<Boolean> mapUsers) {
        RoleResponseDTO dto = new RoleResponseDTO();

        dto.setId(role.getId());
        dto.setUuid(role.getUuid());
        dto.setName(role.getName());
        dto.setCreated_at(role.getCreated_at());
        dto.setUpdated_at(role.getUpdated_at());

        if (mapUsers.orElse(false)) {
           Optional<List<User>> usersWithoutRole = dto.getUsers();

            usersWithoutRole.ifPresent(users -> users.forEach(user -> {
                if (user.getRole() != null) {
                    user.getRole().setUsers(null);
                }
            }));
        }

        return dto;
    }

    public static RoleResponseDTO role_response_mapper (Role role) {
        return role_response_mapper(role, Optional.of(false));
    }
}

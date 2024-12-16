package com.blog.api.features.user.adapters.mappers;

import com.blog.api.features.roles.domain.Role;
import com.blog.api.features.user.adapters.dtos.UserResponseDTO;
import com.blog.api.features.user.domain.User;

import java.util.Optional;

public class UserResponseMapper {
    public static UserResponseDTO user_response_mapper (User user, Optional<Boolean> mapRoles) {
        UserResponseDTO dto = new UserResponseDTO();

        dto.setId(user.getId());
        dto.setUuid(user.getUuid());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());

        if (mapRoles.orElse(false)) {
            Role roleWithoutUsers = user.getRole();

            if (roleWithoutUsers != null) {
                roleWithoutUsers.setUsers(null);
            }

            dto.setRole(roleWithoutUsers);
        }

        dto.setReactions(user.getReactions());
        dto.setPosts(user.getPosts());
        dto.setComments(user.getComments());
        dto.setCreated_at(user.getCreated_at());
        dto.setUpdated_at(user.getUpdated_at());

        return dto;
    }

    public static UserResponseDTO user_response_mapper (User user) {
        return user_response_mapper(user, Optional.of(false));
    }
}

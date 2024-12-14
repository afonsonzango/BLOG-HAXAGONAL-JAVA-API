package com.blog.api.features.user.adapters.mappers;

import com.blog.api.features.comment.domain.Comment;
import com.blog.api.features.post.domain.Post;
import com.blog.api.features.reaction.domain.Reaction;
import com.blog.api.features.roles.domain.Role;
import com.blog.api.features.user.adapters.dtos.UserResponseDTO;
import com.blog.api.features.user.domain.User;

public class UserResponseMapper {
    public static UserResponseDTO user_response_mapper (User user) {
        UserResponseDTO dto = new UserResponseDTO();

        dto.setId(user.getId());
        dto.setUuid(user.getUuid());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        dto.setRole(user.getRole());
        dto.setReactions(user.getReactions());
        dto.setPosts(user.getPosts());
        dto.setComments(user.getComments());
        dto.setCreated_at(user.getCreated_at());
        dto.setUpdated_at(user.getUpdated_at());

        return dto;
    }
}

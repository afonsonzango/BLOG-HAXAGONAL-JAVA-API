package com.blog.api.features.user.application.ports.in;

import com.blog.api.features.user.adapters.dtos.UserRequestDTO;
import com.blog.api.features.user.adapters.dtos.UserResponseDTO;

import java.util.List;

public interface inUserPort {
    List<UserResponseDTO>       getAllUsers();
    UserResponseDTO             getUserById(Long id);
    List<UserResponseDTO>       getUserByName(String name);
    UserResponseDTO             createNewUser(UserRequestDTO user);
    UserRequestDTO              updateExistingUser(Long id, UserRequestDTO user);
    void                        deleteUserById(Long id);
}

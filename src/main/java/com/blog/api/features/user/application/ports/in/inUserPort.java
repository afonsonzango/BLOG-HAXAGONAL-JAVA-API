package com.blog.api.features.user.application.ports.in;

import com.blog.api.features.user.adapters.dtos.UserRequestDTO;
import com.blog.api.features.user.adapters.dtos.UserResponseDTO;

import java.util.List;
import java.util.Optional;

public interface inUserPort {
    List<UserResponseDTO>       getAllUsers();
    UserResponseDTO             getUserById(Long id);
    Optional<UserResponseDTO>   getUserByName(String name);
    Optional<UserResponseDTO>   getUserByEmail(String email);
    UserResponseDTO             createNewUser(UserRequestDTO user);
    UserResponseDTO              updateExistingUser(Long id, UserRequestDTO user);
    void                        deleteUserById(Long id);
}

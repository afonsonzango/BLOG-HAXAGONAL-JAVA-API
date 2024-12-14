package com.blog.api.features.user.application.services;

import com.blog.api.features.user.adapters.dtos.UserRequestDTO;
import com.blog.api.features.user.adapters.dtos.UserResponseDTO;
import com.blog.api.features.user.adapters.repositories.bridges.UserOutRepositoryBridge;
import com.blog.api.features.user.application.ports.in.inUserPort;

import java.util.List;

public class UserServices implements inUserPort {

    private final UserOutRepositoryBridge userOutRepositoryBridge;

    public UserServices(UserOutRepositoryBridge userOutRepositoryBridge) {
        this.userOutRepositoryBridge = userOutRepositoryBridge;
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return List.of();
    }

    @Override
    public UserResponseDTO getUserById(Long id) {
        return null;
    }

    @Override
    public List<UserResponseDTO> getUserByName(String name) {
        return List.of();
    }

    @Override
    public UserResponseDTO createNewUser(UserRequestDTO user) {
        return null;
    }

    @Override
    public UserRequestDTO updateExistingUser(Long id, UserRequestDTO user) {
        return null;
    }

    @Override
    public void deleteUserById(Long id) {

    }
}

package com.blog.api.features.user.application.services;

import com.blog.api.features.roles.adapters.repositories.bridges.RoleOutRepositoryBridge;
import com.blog.api.features.roles.domain.Role;
import com.blog.api.features.user.adapters.dtos.UserRequestDTO;
import com.blog.api.features.user.adapters.dtos.UserResponseDTO;
import com.blog.api.features.user.adapters.mappers.UserResponseMapper;
import com.blog.api.features.user.adapters.repositories.bridges.UserOutRepositoryBridge;
import com.blog.api.features.user.application.ports.in.inUserPort;
import com.blog.api.features.user.domain.User;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class UserServices implements inUserPort {

    private final UserOutRepositoryBridge userOutRepositoryBridge;
    private final RoleOutRepositoryBridge roleOutRepositoryBridge;

    public UserServices(UserOutRepositoryBridge userOutRepositoryBridge, RoleOutRepositoryBridge roleOutRepositoryBridge) {
        this.userOutRepositoryBridge = userOutRepositoryBridge;
        this.roleOutRepositoryBridge = roleOutRepositoryBridge;
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return userOutRepositoryBridge.findAll().stream().map(UserResponseMapper::user_response_mapper).toList();
    }

    @Override
    public UserResponseDTO getUserById(Long id) {
        return userOutRepositoryBridge.findById(id).map(UserResponseMapper::user_response_mapper).orElseThrow(() -> new EntityNotFoundException("Usuario com este id nao encontrado"));
    }

    @Override
    public Optional<UserResponseDTO> getUserByName(String name) {
        return userOutRepositoryBridge.findByName(name).map(UserResponseMapper::user_response_mapper);
    }

    @Override
    public Optional<UserResponseDTO> getUserByEmail(String email) {
        return userOutRepositoryBridge.findByEmail(email).map(UserResponseMapper::user_response_mapper);
    }

    @Override
    public UserResponseDTO createNewUser(UserRequestDTO userRequestDTO) {
        User newUser = new User();

        Role gotRole = roleOutRepositoryBridge
                .findById(userRequestDTO.getRoleId())
                .orElseThrow(() -> new EntityNotFoundException("Role que tentou atribuir nao foi econtrado"));

        newUser.setName(userRequestDTO.getNome());
        newUser.setEmail(userRequestDTO.getEmail());
        newUser.setPassword(userRequestDTO.getPassword());
        newUser.setRole(gotRole);

        User newSavedUser = userOutRepositoryBridge.save(newUser);

        return UserResponseMapper.user_response_mapper(newSavedUser, Optional.of(true));
    }

    @Override
    public UserResponseDTO updateExistingUser(Long id, UserRequestDTO userRequestDTO) {
        User userToUpdate = userOutRepositoryBridge
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuario que tentou actulizazar nao existe"));

        Role newRole = roleOutRepositoryBridge
                .findById(userRequestDTO.getRoleId())
                .orElseThrow(() -> new EntityNotFoundException("role_id que tentou actualizar nao foi encontrado ou nao exiete"));

        userToUpdate.setName(Objects.requireNonNullElse(userRequestDTO.getNome(), userToUpdate.getName()));
        userToUpdate.setEmail(Objects.requireNonNullElse(userRequestDTO.getEmail(), userToUpdate.getEmail()));
        userToUpdate.setPassword(Objects.requireNonNullElse(userRequestDTO.getPassword(), userToUpdate.getPassword()));
        userToUpdate.setRole(Objects.requireNonNullElse(newRole, userToUpdate.getRole()));

        return UserResponseMapper.user_response_mapper(userOutRepositoryBridge.save(userToUpdate), Optional.of(true));
    }

    @Override
    public void deleteUserById(Long id) {
        User userToDelete = userOutRepositoryBridge.findById(id).orElseThrow(() -> new EntityNotFoundException("User nao encontrado ou nao existe"));
        userOutRepositoryBridge.deleteById(userToDelete.getId());
    }
}

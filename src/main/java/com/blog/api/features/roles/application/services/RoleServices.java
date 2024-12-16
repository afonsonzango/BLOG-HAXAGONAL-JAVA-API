package com.blog.api.features.roles.application.services;

import com.blog.api.features.roles.adapters.dtos.RoleRequestDTO;
import com.blog.api.features.roles.adapters.dtos.RoleResponseDTO;
import com.blog.api.features.roles.adapters.mappers.RoleResponseMapper;
import com.blog.api.features.roles.adapters.repositories.bridges.RoleOutRepositoryBridge;
import com.blog.api.features.roles.application.ports.in.inRolePort;
import com.blog.api.features.roles.domain.Role;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

public class RoleServices implements inRolePort {

    private final RoleOutRepositoryBridge roleOutRepositoryBridge;

    public RoleServices (RoleOutRepositoryBridge roleOutRepositoryBridge) {
        this.roleOutRepositoryBridge = roleOutRepositoryBridge;
    }

    @Override
    public List<RoleResponseDTO> getAllRoles() {
        return roleOutRepositoryBridge
                .findAll()
                .stream()
                .map(RoleResponseMapper::role_response_mapper)
                .toList();
    }

    @Override
    public RoleResponseDTO getRoleById(Long id) {
        return roleOutRepositoryBridge
                .findById(id)
                .map(RoleResponseMapper::role_response_mapper)
                .orElseThrow(() -> new EntityNotFoundException("Role com este id nao encontrado"));
    }

    @Override
    public Optional<Role> getRoleByName(String name) {
        return roleOutRepositoryBridge.findByName(name);
    }

    @Override
    public RoleResponseDTO createNewRole(RoleRequestDTO roleRequestDTO) {
        Role role = new Role();
        role.setName(roleRequestDTO.getName());

        Role newSavedRole = roleOutRepositoryBridge.save(role);

        return RoleResponseMapper.role_response_mapper(newSavedRole);
    }

    @Override
    public RoleResponseDTO updateExistingRole(Long id, RoleRequestDTO roleRequestDTO) {
        Role role = roleOutRepositoryBridge
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Role não encontrado"));

        Optional<Role> roleByName = roleOutRepositoryBridge.findByName(roleRequestDTO.getName());

        if (roleByName.isPresent() && !roleByName.get().getId().equals(role.getId())) {
            throw new RuntimeException("Já existe um role com esse nome");
        }

        role.setName(roleRequestDTO.getName());
        Role updatedRole = roleOutRepositoryBridge.save(role);

        return RoleResponseMapper.role_response_mapper(updatedRole);
    }

    @Override
    public void deleteRoleById(Long id) {
        roleOutRepositoryBridge.deleteById(id);
    }
}
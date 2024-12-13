package com.blog.api.features.roles.adapters.cases.create;

import com.blog.api.features.roles.adapters.cases.RoleControllers;
import com.blog.api.features.roles.adapters.dtos.RoleRequestDTO;
import com.blog.api.features.roles.adapters.dtos.RoleResponseDTO;
import com.blog.api.features.roles.application.services.RoleServices;
import com.blog.api.features.roles.domain.Role;
import com.blog.api.root.dtos.APIResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CreateHandler extends RoleControllers {
    private final RoleServices roleServices;

    public CreateHandler(RoleServices roleServices) { this.roleServices = roleServices; }

    @PostMapping("/create")
    public APIResponseDTO<RoleResponseDTO> handler (@Valid @RequestBody RoleRequestDTO roleRequestDTO) {
        try {
            Optional<List<Role>> roleByName = roleServices.getRoleByName(roleRequestDTO.getName());

            if (roleByName.isPresent() && !roleByName.get().isEmpty()) {
                return new APIResponseDTO<>(true, HttpStatus.CONFLICT, "Role que tentou cadastrar já existe", null);
            }

            RoleResponseDTO newRole = roleServices.createNewRole(roleRequestDTO);

            return new APIResponseDTO<>(false, HttpStatus.CREATED, "Role criado com sucesso", newRole);
        } catch (Exception e) {
            return new APIResponseDTO<>(true, HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno da aplicacao", null);
        }
    }
}
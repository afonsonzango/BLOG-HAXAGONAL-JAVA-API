package com.blog.api.features.user.adapters.cases.find_all;

import com.blog.api.features.user.adapters.cases.UserControllers;
import com.blog.api.features.user.adapters.dtos.UserResponseDTO;
import com.blog.api.features.user.adapters.mappers.UserResponseMapper;
import com.blog.api.features.user.adapters.repositories.bridges.UserOutRepositoryBridge;
import com.blog.api.root.dtos.APIResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserFindAllHandler extends UserControllers {
    private final UserOutRepositoryBridge userOutRepositoryBridge;

    public UserFindAllHandler(UserOutRepositoryBridge userOutRepositoryBridge) {
        this.userOutRepositoryBridge = userOutRepositoryBridge;
    }

    @GetMapping("/all")
    public APIResponseDTO<List<UserResponseDTO>> handler () {
        try {
            List<UserResponseDTO> users = userOutRepositoryBridge
                    .findAll()
                    .stream()
                    .map(user -> UserResponseMapper.userResponseMapper(user, Optional.of(true)))
                    .toList();

            if (users.isEmpty()) return new APIResponseDTO<>(false, HttpStatus.OK, "Nenhum ususario registrado no momento", null);

            return new APIResponseDTO<>(false, HttpStatus.OK, "Usuarios buscados com sucesso", users);
        } catch (Exception e) {
            return new APIResponseDTO<>(true, HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao buscar usuarios", null);
        }
    }
}
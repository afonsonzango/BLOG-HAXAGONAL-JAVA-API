package com.blog.api.features.user.adapters.cases.find_by_id;

import com.blog.api.features.user.adapters.cases.UserControllers;
import com.blog.api.features.user.adapters.dtos.UserResponseDTO;
import com.blog.api.features.user.adapters.mappers.UserResponseMapper;
import com.blog.api.features.user.adapters.repositories.bridges.UserOutRepositoryBridge;
import com.blog.api.root.dtos.APIResponseDTO;
import com.blog.api.root.utils.ValueUtilities;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserFindByIdHandler extends UserControllers {
    private final UserOutRepositoryBridge userOutRepositoryBridge;

    public UserFindByIdHandler (UserOutRepositoryBridge userOutRepositoryBridge) {
        this.userOutRepositoryBridge = userOutRepositoryBridge;
    }

    @GetMapping("{id}")
    public APIResponseDTO<UserResponseDTO> handler (@PathVariable String id) {

        if (ValueUtilities.isNotNumber(id)) return new APIResponseDTO<>(true, HttpStatus.BAD_REQUEST, "Id inserido eh invalido", null);

        try {
            Long longedId = Long.parseLong(id);
            UserResponseDTO userById = userOutRepositoryBridge
                    .findById(longedId)
                    .map((user) -> UserResponseMapper.user_response_mapper(user, Optional.of(true)))
                    .orElseThrow(() -> new EntityNotFoundException("Usuario nao econtrado"));

            return new APIResponseDTO<>(false, HttpStatus.OK, "Usuario buscado com sucesso", userById);
        } catch (EntityNotFoundException e) {
            return new APIResponseDTO<>(true, HttpStatus.NOT_FOUND, "Usuario nao encontrado", null);
        } catch (Exception e) {
            return new APIResponseDTO<>(true, HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno ao buscar ususarios", null);
        }
    }
}
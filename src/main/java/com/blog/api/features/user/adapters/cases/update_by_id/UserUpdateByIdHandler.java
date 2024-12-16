package com.blog.api.features.user.adapters.cases.update_by_id;

import com.blog.api.features.user.adapters.cases.UserControllers;
import com.blog.api.features.user.adapters.dtos.UserRequestDTO;
import com.blog.api.features.user.adapters.dtos.UserResponseDTO;
import com.blog.api.features.user.adapters.mappers.UserResponseMapper;
import com.blog.api.features.user.application.services.UserServices;
import com.blog.api.features.user.domain.User;
import com.blog.api.root.dtos.APIResponseDTO;
import com.blog.api.root.utils.ValueUtilities;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserUpdateByIdHandler extends UserControllers {
    private final UserServices userServices;

    public UserUpdateByIdHandler (UserServices userServices) {
        this.userServices = userServices;
    }

    @PutMapping("/update/{id}")
    public APIResponseDTO<UserResponseDTO> handler (@Valid @RequestBody UserRequestDTO userRequestDTO, @PathVariable String id) {

        if (ValueUtilities.isNotNumber(id)) return new APIResponseDTO<>(true, HttpStatus.BAD_REQUEST, "id que inseriu eh invalido", null);

        try {
            Long userToUpdateId = Long.parseLong(id);
            Optional<UserResponseDTO> userByEmailExists = userServices.getUserByEmail(userRequestDTO.getEmail());

            if (userByEmailExists.isPresent() && !userByEmailExists.get().getId().equals(userToUpdateId)) return new APIResponseDTO<>(true, HttpStatus.BAD_REQUEST, "Ja existe um outro user com esse email", null);

            UserResponseDTO savedUser = userServices.updateExistingUser(userToUpdateId, userRequestDTO);

            return new APIResponseDTO<>(false, HttpStatus.OK, "Usuario actualizado com sucesso!", savedUser);
        } catch (EntityNotFoundException e) {
            return new APIResponseDTO<>(true, HttpStatus.BAD_REQUEST, e.getMessage(), null);
        } catch (Exception e) {
            return new APIResponseDTO<>(true, HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno do servidor", null);
        }
    }
}

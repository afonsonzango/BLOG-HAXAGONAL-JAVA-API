package com.blog.api.features.user.adapters.cases.create;

import com.blog.api.features.user.adapters.cases.UserControllers;
import com.blog.api.features.user.adapters.dtos.UserRequestDTO;
import com.blog.api.features.user.adapters.dtos.UserResponseDTO;
import com.blog.api.features.user.application.services.UserServices;
import com.blog.api.root.dtos.APIResponseDTO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserCreateHandler extends UserControllers {
    private final UserServices userServices;

    public UserCreateHandler (UserServices userServices) {
        this.userServices = userServices;
    }

    @PostMapping("create")
    public APIResponseDTO<UserResponseDTO> handler (@Valid @RequestBody UserRequestDTO userRequestDTO) {
        try {
            Optional<UserResponseDTO> userByEmail = userServices.getUserByEmail(userRequestDTO.getEmail());

            if (userByEmail.isPresent()) return new APIResponseDTO<>(true, HttpStatus.CONFLICT, "ja existe algum usuario com esse email", null);

            UserResponseDTO newUser = userServices.createNewUser(userRequestDTO);

            return new APIResponseDTO<>(false, HttpStatus.CREATED, "Usuario criado com sucesso", newUser);
        } catch (EntityNotFoundException e) {
            return new APIResponseDTO<>(true, HttpStatus.NOT_FOUND, e.getMessage(), null);
        } catch (Exception e) {
            return new APIResponseDTO<>(true, HttpStatus.INTERNAL_SERVER_ERROR, "Algum erro aconteceu ao criar usuario", null);
        }
    }
}

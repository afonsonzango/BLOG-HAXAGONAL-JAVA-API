package com.blog.api.features.user.adapters.cases.delete_by_id;

import com.blog.api.features.user.adapters.cases.UserControllers;
import com.blog.api.features.user.application.services.UserServices;
import com.blog.api.root.dtos.APIResponseDTO;
import com.blog.api.root.utils.ValueUtilities;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserDeleteByIdHandler extends UserControllers {
    private final UserServices userServices;

    public UserDeleteByIdHandler (UserServices userServices) {
        this.userServices = userServices;
    }

    @DeleteMapping("delete/{id}")
    public APIResponseDTO handler (@PathVariable String id) {
        if (ValueUtilities.isNotNumber(id)) return new APIResponseDTO<>(true, HttpStatus.BAD_REQUEST, "Id que inseriu eh invalido", null);

        try {
            Long userIdToDelete = Long.parseLong(id);
            userServices.deleteUserById(userIdToDelete);

            return new APIResponseDTO<>(false, HttpStatus.OK, "Usuario deletado com sucesso", null);
        } catch (EntityNotFoundException e) {
            return new APIResponseDTO<>(true, HttpStatus.NOT_FOUND, e.getMessage(), null);
        } catch (Exception e) {
            return new APIResponseDTO<>(true, HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno do servidor", null);
        }
    }
}

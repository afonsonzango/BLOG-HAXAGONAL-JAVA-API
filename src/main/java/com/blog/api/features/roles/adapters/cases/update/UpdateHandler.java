package com.blog.api.features.roles.adapters.cases.update;

import com.blog.api.features.roles.adapters.cases.RoleControllers;
import com.blog.api.features.roles.adapters.dtos.RoleRequestDTO;
import com.blog.api.features.roles.adapters.dtos.RoleResponseDTO;
import com.blog.api.features.roles.application.services.RoleServices;
import com.blog.api.root.dtos.APIResponseDTO;
import com.blog.api.root.utils.ValueUtilities;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateHandler extends RoleControllers {
    private final RoleServices roleServices;

    public UpdateHandler (RoleServices roleServices) {
        this.roleServices = roleServices;
    }

    @PutMapping("/update/{id}")
    public APIResponseDTO<RoleResponseDTO> handler (@PathVariable String id, @Valid @RequestBody RoleRequestDTO roleRequestDTO) {

        if (ValueUtilities.isNotNumber(id)) return new APIResponseDTO<>(true, HttpStatus.BAD_REQUEST, "Id do role invalido", null);

        try {
            Long newId = Long.parseLong(id);
            RoleResponseDTO updatedRole = roleServices.updateExistingRole(newId, roleRequestDTO);

            return new APIResponseDTO<>(false, HttpStatus.ACCEPTED, "Role actualizado com sucesso", updatedRole);
        } catch (EntityNotFoundException e) {
            return new APIResponseDTO<>(true, HttpStatus.NOT_FOUND, e.getMessage(), null);
        } catch (RuntimeException e) {
            return new APIResponseDTO<>(true, HttpStatus.NOT_ACCEPTABLE, e.getMessage(), null);
        } catch (Exception e) {
            return new APIResponseDTO<>(true, HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao actualizar role", null);
        }
    }
}
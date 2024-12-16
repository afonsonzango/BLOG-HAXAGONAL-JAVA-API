package com.blog.api.features.roles.adapters.cases.find_by_id;

import com.blog.api.features.roles.adapters.cases.RoleControllers;
import com.blog.api.features.roles.adapters.dtos.RoleResponseDTO;
import com.blog.api.features.roles.application.services.RoleServices;
import com.blog.api.root.dtos.APIResponseDTO;
import com.blog.api.root.utils.ValueUtilities;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleFindByIdHandler extends RoleControllers {
    private final RoleServices roleServices;

    public RoleFindByIdHandler(RoleServices roleServices) {
        this.roleServices = roleServices;
    }

    @GetMapping("{id}")
    public APIResponseDTO<RoleResponseDTO> handler (@PathVariable String id) {

        if (ValueUtilities.isNotNumber(id)) return new APIResponseDTO<>(true, HttpStatus.BAD_REQUEST, "Id inserido eh invalido", null);

        try {
            Long newId = Long.parseLong(id);
            RoleResponseDTO role = roleServices.getRoleById(newId);

            return new APIResponseDTO<>(false, HttpStatus.OK, "Role encontrado", role);
        } catch (EntityNotFoundException e) {
            return new APIResponseDTO<>(true, HttpStatus.NOT_FOUND, e.getMessage(), null);
        } catch (Exception e) {
            return new APIResponseDTO<>(true, HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao nuscar role por id", null);
        }
    }
}
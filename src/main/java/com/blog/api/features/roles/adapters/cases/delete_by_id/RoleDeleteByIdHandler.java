package com.blog.api.features.roles.adapters.cases.delete_by_id;

import com.blog.api.features.roles.adapters.cases.RoleControllers;
import com.blog.api.features.roles.application.services.RoleServices;
import com.blog.api.root.dtos.APIResponseDTO;
import com.blog.api.root.utils.ValueUtilities;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleDeleteByIdHandler extends RoleControllers {
    private final RoleServices roleServices;

    public RoleDeleteByIdHandler(RoleServices roleServices) {
        this.roleServices = roleServices;
    }

    @DeleteMapping("/delete/{id}")
    public APIResponseDTO handle (@PathVariable String id) {

        if (ValueUtilities.isNotNumber(id)) return new APIResponseDTO<>(true, HttpStatus.BAD_GATEWAY, "Id inserido eh invalido", null);

        try {
            Long newId = Long.parseLong(id);
            roleServices.deleteRoleById(newId);

            return new APIResponseDTO<>(false, HttpStatus.NO_CONTENT, "Role deletado com sucesso", null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
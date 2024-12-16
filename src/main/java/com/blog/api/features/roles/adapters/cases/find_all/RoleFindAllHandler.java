package com.blog.api.features.roles.adapters.cases.find_all;

import com.blog.api.features.roles.adapters.cases.RoleControllers;
import com.blog.api.features.roles.adapters.dtos.RoleResponseDTO;
import com.blog.api.features.roles.application.services.RoleServices;
import com.blog.api.root.dtos.APIResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleFindAllHandler extends RoleControllers {
    private final RoleServices roleServices;

    public RoleFindAllHandler(RoleServices roleServices) {
        this.roleServices = roleServices;
    }

    @GetMapping("/all")
    public APIResponseDTO<List<RoleResponseDTO>> handler() {
        try {
            List<RoleResponseDTO> roles = roleServices.getAllRoles();

            if (roles.isEmpty()) {
                return new APIResponseDTO<>(false, HttpStatus.OK, "Nenhum role registrado", null);
            }

            return new APIResponseDTO<>(false, HttpStatus.OK, "Roles buscados com sucesso", roles);
        } catch (Exception e) {
            return new APIResponseDTO<>(true, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null);
        }
    }
}
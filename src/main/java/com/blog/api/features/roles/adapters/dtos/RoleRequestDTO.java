package com.blog.api.features.roles.adapters.dtos;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class RoleRequestDTO {
    @NotBlank(message = "Nome do role eh obrigatorio")
    @Length(min = 4, max = 100, message = "Role deve ter entre 4 e 100 caracteres")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
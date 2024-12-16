package com.blog.api.features.user.adapters.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

public class UserRequestDTO {
    @NotBlank(message = "Nome nao pode estar vazio")
    @Length(min = 3, max = 100, message = "Nome deve ter entre 3 a 100 caracteres")
    private String name;

    @NotBlank(message = "Email eh um campo obrigatorio")
    @Length(min = 6, max = 100, message = "Email deve ter entre 6 a 100 caracteres")
    @Email(message = "Formato de email invalido")
    private String email;

    @NotBlank(message = "Password eh um campo obrigatorio")
    @Length(min = 8, max = 36, message = "Campo password deve ter entre 8 a 36 caracteres")
    private String password;

    @NotNull(message = "role_id eh um campo obrigatorio")
    @Positive(message = "role_id invalido")
    private Long roleId;

    public String getNome() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
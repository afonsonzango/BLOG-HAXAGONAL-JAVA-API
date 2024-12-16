package com.blog.api.features.roles.adapters.dtos;

import com.blog.api.features.user.domain.User;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoleResponseDTO {
    private Long id;
    private UUID uuid;
    private String name;
    private Optional<List<User>> users;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public RoleResponseDTO() {}

    public RoleResponseDTO(Long id, UUID uuid, String name, Optional<List<User>> users, LocalDateTime created_at, LocalDateTime updated_at) {
        this.id = id;
        this.uuid = uuid;
        this.name = name;
        this.users = users;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Optional<List<User>> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = Optional.ofNullable(users);
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }
}
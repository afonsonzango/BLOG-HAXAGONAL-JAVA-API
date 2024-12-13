package com.blog.api.features.roles.application.ports.out;

import com.blog.api.features.roles.domain.Role;

import java.util.List;
import java.util.Optional;

public interface outRolePort {
    List<Role>          findAll();
    Optional<Role>      findById(Long id);
    Role                save(Role role);
    Optional<List<Role>> findByName(String name);
    void                deleteById(Long id);
}
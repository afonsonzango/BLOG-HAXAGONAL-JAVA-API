package com.blog.api.features.roles.adapters.repositories;

import com.blog.api.features.roles.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<List<Role>> findByName(String name);
}
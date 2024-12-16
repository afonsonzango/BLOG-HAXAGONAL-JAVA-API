package com.blog.api.features.roles.adapters.repositories.bridges;
import com.blog.api.features.roles.adapters.repositories.RoleRepository;
import com.blog.api.features.roles.application.ports.out.outRolePort;
import com.blog.api.features.roles.domain.Role;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RoleOutRepositoryBridge implements outRolePort {

    private final RoleRepository roleRepository;

    public RoleOutRepositoryBridge(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> findById(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    public Optional<Role> findByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public void deleteById(Long id) {
        roleRepository.deleteById(id);
    }
}
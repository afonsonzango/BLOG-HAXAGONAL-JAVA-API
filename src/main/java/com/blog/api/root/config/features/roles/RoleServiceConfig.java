package com.blog.api.root.config.features.roles;

import com.blog.api.features.roles.adapters.repositories.bridges.RoleOutRepositoryBridge;
import com.blog.api.features.roles.application.services.RoleServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoleServiceConfig {
    private final RoleOutRepositoryBridge roleOutRepositoryBridge;

    public RoleServiceConfig (RoleOutRepositoryBridge roleOutRepositoryBridge) {
        this.roleOutRepositoryBridge = roleOutRepositoryBridge;
    }

    @Bean
    public RoleServices roleServices () {
        return new RoleServices(roleOutRepositoryBridge);
    }
}











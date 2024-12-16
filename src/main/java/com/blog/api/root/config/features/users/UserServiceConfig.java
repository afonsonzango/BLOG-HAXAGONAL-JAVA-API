package com.blog.api.root.config.features.users;

import com.blog.api.features.roles.adapters.repositories.bridges.RoleOutRepositoryBridge;
import com.blog.api.features.user.adapters.repositories.bridges.UserOutRepositoryBridge;
import com.blog.api.features.user.application.services.UserServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserServiceConfig {
    private final UserOutRepositoryBridge userOutRepositoryBridge;
    private final RoleOutRepositoryBridge roleOutRepositoryBridge;

    public UserServiceConfig (UserOutRepositoryBridge userOutRepositoryBridge, RoleOutRepositoryBridge roleOutRepositoryBridge) {
        this.userOutRepositoryBridge = userOutRepositoryBridge;
        this.roleOutRepositoryBridge = roleOutRepositoryBridge;
    }

    @Bean
    public UserServices userServices () { return new UserServices(userOutRepositoryBridge, roleOutRepositoryBridge); }
}

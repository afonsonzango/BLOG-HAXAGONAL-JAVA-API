package com.blog.api.root.config.users;

import com.blog.api.features.user.adapters.repositories.bridges.UserOutRepositoryBridge;
import com.blog.api.features.user.application.services.UserServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserServiceConfig {
    private final UserOutRepositoryBridge userOutRepositoryBridge;

    public UserServiceConfig (UserOutRepositoryBridge userOutRepositoryBridge) {
        this.userOutRepositoryBridge = userOutRepositoryBridge;
    }

    @Bean
    public UserServices userServices () { return new UserServices(userOutRepositoryBridge); }
}

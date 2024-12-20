package com.blog.api.root.config.features.posts;

import com.blog.api.features.post.adapters.repositories.bridges.PostOutRepositoryBridge;
import com.blog.api.features.post.application.services.PostServices;
import com.blog.api.features.user.adapters.repositories.bridges.UserOutRepositoryBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostServiceConfig {
    private final PostOutRepositoryBridge postOutRepositoryBridge;
    private final UserOutRepositoryBridge userOutRepositoryBridge;

    public PostServiceConfig (PostOutRepositoryBridge postOutRepositoryBridge, UserOutRepositoryBridge userOutRepositoryBridge) {
        this.postOutRepositoryBridge = postOutRepositoryBridge;
        this.userOutRepositoryBridge = userOutRepositoryBridge;
    }

    @Bean
    public PostServices postServices () {
        return new PostServices(postOutRepositoryBridge, userOutRepositoryBridge);
    }
}
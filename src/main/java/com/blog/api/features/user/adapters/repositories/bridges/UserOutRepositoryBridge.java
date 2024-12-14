package com.blog.api.features.user.adapters.repositories.bridges;

import com.blog.api.features.user.adapters.repositories.UserRepository;
import com.blog.api.features.user.domain.User;
import org.springframework.stereotype.Component;

import com.blog.api.features.user.application.ports.out.outUserPort;

import java.util.List;
import java.util.Optional;

@Component
public class UserOutRepositoryBridge implements outUserPort {

    private final UserRepository userRepository;

    public UserOutRepositoryBridge (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<List<User>> findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}

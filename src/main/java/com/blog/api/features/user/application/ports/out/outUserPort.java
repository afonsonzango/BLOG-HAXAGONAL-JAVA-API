package com.blog.api.features.user.application.ports.out;

import com.blog.api.features.user.domain.User;

import java.util.List;
import java.util.Optional;

public interface outUserPort {
    List<User>              findAll();
    Optional<User>          findById(Long id);
    User                    save(User user);
    Optional<User>          findByName(String name);
    Optional<User>          findByEmail(String email);
    void                    deleteById(Long id);
}

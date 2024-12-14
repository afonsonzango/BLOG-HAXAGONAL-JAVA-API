package com.blog.api.features.user.adapters.repositories;

import com.blog.api.features.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<List<User>> findByName(String name);
}

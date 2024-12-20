package com.blog.api.features.post.adapters.repositories;

import com.blog.api.features.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<List<Post>> findByTitle(String title);
}

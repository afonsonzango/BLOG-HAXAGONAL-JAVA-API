package com.blog.api.features.post.application.ports.out;

import com.blog.api.features.post.domain.Post;

import java.util.List;
import java.util.Optional;

public interface outPostPort {
    List<Post>                  findAll();
    Optional<Post>              findById(Long id);
    Post                        save(Post post);
    Optional<List<Post>>        findByTitle(String name);
    void                        deleteById(Long id);
}
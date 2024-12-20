package com.blog.api.features.post.adapters.repositories.bridges;

import com.blog.api.features.post.adapters.repositories.PostRepository;
import com.blog.api.features.post.application.ports.out.outPostPort;
import com.blog.api.features.post.domain.Post;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PostOutRepositoryBridge implements outPostPort {

    private final PostRepository postRepository;

    public PostOutRepositoryBridge (PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Optional<List<Post>> findByTitle(String title) {
        return postRepository.findByTitle(title);
    }

    @Override
    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }
}
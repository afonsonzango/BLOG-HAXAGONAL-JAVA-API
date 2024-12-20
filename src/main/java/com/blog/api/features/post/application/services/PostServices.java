package com.blog.api.features.post.application.services;

import com.blog.api.features.post.adapters.dtos.PostRequestDTO;
import com.blog.api.features.post.adapters.dtos.PostResponseDTO;
import com.blog.api.features.post.adapters.mappers.PostResponseMapper;
import com.blog.api.features.post.adapters.repositories.bridges.PostOutRepositoryBridge;
import com.blog.api.features.post.application.ports.in.inPostPort;
import com.blog.api.features.post.domain.Post;
import com.blog.api.features.user.adapters.repositories.bridges.UserOutRepositoryBridge;
import com.blog.api.features.user.domain.User;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Objects;

public class PostServices implements inPostPort {

    private final PostOutRepositoryBridge postOutRepositoryBridge;
    private final UserOutRepositoryBridge userOutRepositoryBridge;

    public PostServices (PostOutRepositoryBridge postOutRepositoryBridge, UserOutRepositoryBridge userOutRepositoryBridge) {
        this.postOutRepositoryBridge = postOutRepositoryBridge;
        this.userOutRepositoryBridge = userOutRepositoryBridge;
    }

    @Override
    public List<PostResponseDTO> getAllPosts () {
        return postOutRepositoryBridge.findAll().stream().map(PostResponseMapper::postResponseDTO).toList();
    }

    @Override
    public PostResponseDTO getPostById (Long id) {
        Post postById = postOutRepositoryBridge
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Post nao econtrado"));

        return PostResponseMapper.postResponseDTO(postById);
    }

    @Override
    public List<PostResponseDTO> getPostByTitle (String title) {
        List<Post> posts = postOutRepositoryBridge.
                findByTitle(title)
                .orElseThrow(() -> new EntityNotFoundException("Nenhum post encontrado para o titulo " + title));

        return posts.stream().map(PostResponseMapper::postResponseDTO).toList();
    }

    @Override
    public PostResponseDTO createNewPost (PostRequestDTO newPostData) {
        Post post = new Post();

        User creatorUser = userOutRepositoryBridge
                .findById(newPostData.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("Usuario nao encontrado ou inexistente"));

        post.setTags(newPostData.getTags());
        post.setTitle(newPostData.getTitle());
        post.setContent(newPostData.getContent());
        post.setUser(creatorUser);

        Post savedPost = postOutRepositoryBridge.save(post);

        return PostResponseMapper.postResponseDTO(savedPost);
    }

    @Override
    public PostResponseDTO updateExistingPost(Long id, PostRequestDTO postUpdates) {
        Post postToUpdate = postOutRepositoryBridge
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Post a ser actualizado nao encontrado"));

        postToUpdate.setTags(Objects.requireNonNullElse(postUpdates.getTags(), postToUpdate.getTags()));
        postToUpdate.setTitle(Objects.requireNonNullElse(postUpdates.getTitle(), postToUpdate.getTitle()));
        postToUpdate.setContent(Objects.requireNonNullElse(postUpdates.getContent(), postToUpdate.getContent()));

        return PostResponseMapper.postResponseDTO(postOutRepositoryBridge.save(postToUpdate));
    }

    @Override
    public void deletePostById (Long id) {
        postOutRepositoryBridge.deleteById(id);
    }
}

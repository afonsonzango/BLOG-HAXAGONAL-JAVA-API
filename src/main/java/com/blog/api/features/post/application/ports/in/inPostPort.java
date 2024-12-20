package com.blog.api.features.post.application.ports.in;

import com.blog.api.features.post.adapters.dtos.PostRequestDTO;
import com.blog.api.features.post.adapters.dtos.PostResponseDTO;

import java.util.List;
import java.util.Optional;

public interface inPostPort {
    List<PostResponseDTO>           getAllPosts();
    PostResponseDTO                 getPostById(Long id);
    List<PostResponseDTO>           getPostByTitle(String title);
    PostResponseDTO                 createNewPost(PostRequestDTO user);
    PostResponseDTO                 updateExistingPost(Long id, PostRequestDTO user);
    void                            deletePostById(Long id);
}

package com.blog.api.features.post.adapters.cases.create;

import com.blog.api.features.post.adapters.cases.PostControllers;
import com.blog.api.features.post.adapters.dtos.PostRequestDTO;
import com.blog.api.features.post.adapters.dtos.PostResponseDTO;
import com.blog.api.features.post.application.services.PostServices;
import com.blog.api.root.dtos.APIResponseDTO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostCreateHandler extends PostControllers {

    private final PostServices postServices;

    public PostCreateHandler (PostServices postServices) {
        this.postServices = postServices;
    }

    @PostMapping("/create")
    public APIResponseDTO<PostResponseDTO> handler (@Valid @RequestBody PostRequestDTO postRequestDTO) {
        try {
            PostRequestDTO newPost = new PostRequestDTO();

            newPost.setTags(postRequestDTO.getTags());
            newPost.setTitle(postRequestDTO.getTitle());
            newPost.setContent(postRequestDTO.getContent());
            newPost.setUserId(postRequestDTO.getUserId());

            PostResponseDTO savedPost = postServices.createNewPost(newPost);

            return new APIResponseDTO<>(false, HttpStatus.OK, "Post criado com sucesso", savedPost);
        } catch (EntityNotFoundException e) {
            return new APIResponseDTO<>(true, HttpStatus.BAD_REQUEST, e.getMessage(), null);
        } catch (Exception e) {
            return new APIResponseDTO<>(true, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null);
        }
    }
}
package com.blog.api.features.post.adapters.cases.find_all;

import com.blog.api.features.post.adapters.cases.PostControllers;
import com.blog.api.features.post.adapters.dtos.PostResponseDTO;
import com.blog.api.features.post.application.services.PostServices;
import com.blog.api.root.dtos.APIResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostFindAllHandler extends PostControllers {

    private final PostServices postServices;

    public PostFindAllHandler (PostServices postServices) {
        this.postServices = postServices;
    }

    @GetMapping("/all")
    public APIResponseDTO<List<PostResponseDTO>> handler () {
        try {
            List<PostResponseDTO> postList = postServices.getAllPosts();

            if (postList.isEmpty()) return new APIResponseDTO<>(false, HttpStatus.OK, "Nenhum post registrado no sistema", null);

            return new APIResponseDTO<>(false, HttpStatus.OK, "Todos os posts do sistema", postList);
        } catch (Exception e) {
            return new APIResponseDTO<>(true, HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno do servidor", null);
        }
    }
}
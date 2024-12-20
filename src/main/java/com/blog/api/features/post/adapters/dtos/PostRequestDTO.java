package com.blog.api.features.post.adapters.dtos;

import com.blog.api.root.config.validation.is_array.IsArray;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;

import java.util.List;
import java.util.Optional;

public class PostRequestDTO {
    @NotBlank(message = "Titulo eh um campo obrigatorio")
    @Length(min = 1, max = 144, message = "Titulo requer no minimo 1 caractere e menos de 144")
    private String title;

    private Optional<List<String>> tags = Optional.empty();

    @NotBlank(message = "Content eh um campo orbigatorio")
    @Length(min = 10, max=10000, message = "Este campo requer no minimo 10 caracteres e maximo 10000")
    private String content;

    @NotNull(message = "userId nao pode ser nulo")
    private Long userId;

    public PostRequestDTO () {}

    public PostRequestDTO(String title, Optional<List<String>> tags, String content, Long userId) {
        this.title = title;
        this.tags = tags;
        this.content = content;
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getTags() {
        return tags.orElse(null);
    }

    public void setTags(List<String> tags) {
        this.tags = Optional.ofNullable(tags);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
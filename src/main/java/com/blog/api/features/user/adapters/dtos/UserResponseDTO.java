package com.blog.api.features.user.adapters.dtos;

import com.blog.api.features.comment.domain.Comment;
import com.blog.api.features.post.domain.Post;
import com.blog.api.features.reaction.domain.Reaction;
import com.blog.api.features.roles.domain.Role;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class UserResponseDTO {
    private Long id;
    private UUID uuid;
    private String name;
    private String email;
    private String password;
    private Role role;
    private Optional<List<Reaction>> reactions = Optional.empty();
    private Optional<List<Post>> posts = Optional.empty();
    private Optional<List<Comment>> comments = Optional.empty();
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public UserResponseDTO () {}

    public UserResponseDTO(Long id, UUID uuid, String name, String email, String password, Role role, Optional<List<Reaction>> reactions, Optional<List<Post>> posts, Optional<List<Comment>> comments, LocalDateTime created_at, LocalDateTime updated_at) {
        this.id = id;
        this.uuid = uuid;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.reactions = reactions;
        this.posts = posts;
        this.comments = comments;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Optional<List<Reaction>> getReactions() {
        return reactions;
    }

    public void setReactions(List<Reaction> reactions) {
        this.reactions = Optional.ofNullable(reactions);
    }

    public Optional<List<Post>> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = Optional.ofNullable(posts);
    }

    public Optional<List<Comment>> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = Optional.ofNullable(comments);
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }
}

package com.blog.api.features.post.adapters.dtos;

import com.blog.api.features.comment.domain.Comment;
import com.blog.api.features.reaction.domain.Reaction;
import com.blog.api.features.user.domain.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PostResponseDTO {
    private Long id;
    private UUID uuid;
    private String title;
    private Optional<List<String>> tags = Optional.empty();
    private String content;
    private Optional<List<Comment>> comments = Optional.empty();
    private Optional<List<Reaction>> reactions = Optional.empty();
    private User user;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public PostResponseDTO () {}

    public PostResponseDTO(Long id, UUID uuid, String title, Optional<List<String>> tags, String content, Optional<List<Comment>> comments, Optional<List<Reaction>> reactions, User user, LocalDateTime created_at, LocalDateTime updated_at) {
        this.id = id;
        this.uuid = uuid;
        this.title = title;
        this.tags = tags;
        this.content = content;
        this.comments = comments;
        this.reactions = reactions;
        this.user = user;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Optional<List<String>> getTags() {
        return tags;
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

    public Optional<List<Comment>> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = Optional.ofNullable(comments);
    }

    public Optional<List<Reaction>> getReactions() {
        return reactions;
    }

    public void setReactions(List<Reaction> reactions) {
        this.reactions = Optional.ofNullable(reactions);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
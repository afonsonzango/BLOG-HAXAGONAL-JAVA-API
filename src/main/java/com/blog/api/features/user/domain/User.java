package com.blog.api.features.user.domain;

import jakarta.persistence.*;
import com.blog.api.features.post.domain.Post;
import com.blog.api.features.roles.domain.Role;
import com.blog.api.features.comment.domain.Comment;
import com.blog.api.features.reaction.domain.Reaction;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(unique = true, nullable = false)
    private UUID uuid;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @PrePersist
    protected void prepareForPersist() {
        if (this.uuid == null) {
            this.uuid = UUID.randomUUID();
        }

        if (password != null && !password.startsWith("$2a$")) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            this.password = encoder.encode(password);
        }
    }

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Optional<List<Reaction>> reactions;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Optional<List<Post>> posts;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Optional<List<Comment>> comments;

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private LocalDateTime created_at;

    @UpdateTimestamp
    private LocalDateTime updated_at;


    public User() { }

    public User(Long id, UUID uuid, String name, String email, String password, Role role, Optional<List<Reaction>> reactions, Optional<List<Post>> posts, Optional<List<Comment>> comments, LocalDateTime created_at, LocalDateTime updated_at) {
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

    public void setReactions(Optional<List<Reaction>> reactions) {
        this.reactions = reactions;
    }

    public Optional<List<Post>> getPosts() {
        return posts;
    }

    public void setPosts(Optional<List<Post>> posts) {
        this.posts = posts;
    }

    public Optional<List<Comment>> getComments() {
        return comments;
    }

    public void setComments(Optional<List<Comment>> comments) {
        this.comments = comments;
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
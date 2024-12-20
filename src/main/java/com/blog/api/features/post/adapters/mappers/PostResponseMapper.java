package com.blog.api.features.post.adapters.mappers;

import com.blog.api.features.comment.domain.Comment;
import com.blog.api.features.post.adapters.dtos.PostResponseDTO;
import com.blog.api.features.post.domain.Post;
import com.blog.api.features.reaction.domain.Reaction;
import com.blog.api.features.user.domain.User;

import java.util.List;

public class PostResponseMapper {
    private PostResponseMapper() {}

    public static PostResponseDTO postResponseDTO (Post post) {
        PostResponseDTO dto = new PostResponseDTO();

        dto.setId(post.getId());
        dto.setUuid(post.getUuid());
        dto.setTitle(post.getTitle());
        dto.setContent(post.getContent());
        dto.setTags(post.getTags());

        List<Comment> commentsWidthOut = post.getComments();
        List<Reaction> reactionsWithOut = post.getReactions();
        User userWithOut = post.getUser();

        if (commentsWidthOut != null) {
            commentsWidthOut.forEach(comment -> {
                comment.setPost(null);
                comment.setUser(null);
                comment.setReactions(null);
            });
        }

        if (reactionsWithOut != null) {
            reactionsWithOut.forEach(reaction -> {
                reaction.setPost(null);
                reaction.setUser(null);
                reaction.setComment(null);
            });
        }

        userWithOut.setReactions(null);
        userWithOut.setPosts(null);
        userWithOut.setComments(null);
        userWithOut.getRole().setUsers(null);

        dto.setComments(commentsWidthOut);
        dto.setReactions(reactionsWithOut);
        dto.setUser(userWithOut);

        dto.setCreated_at(post.getCreated_at());
        dto.setUpdated_at(post.getUpdated_at());

        return dto;
    }
}
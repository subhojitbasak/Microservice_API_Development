package com.myblog.rest.api.Service.impl;

import com.myblog.rest.api.Entities.Comment;
import com.myblog.rest.api.Entities.Post;
import com.myblog.rest.api.Exception.ResourceNotFoundException;
import com.myblog.rest.api.Payload.CommentDto;
import com.myblog.rest.api.Repository.CommentRepository;
import com.myblog.rest.api.Repository.PostRepository;
import com.myblog.rest.api.Service.CommentService;

public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepo;
    private PostRepository postRepo;

    public CommentServiceImpl(CommentRepository commentRepo, PostRepository postRepo) {
        this.commentRepo = commentRepo;
        this.postRepo = postRepo;
    }


    @Override
    public CommentDto createCommentDto(long postId,CommentDto commentDto) {
        Post post = postRepo.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("post", "id", postId)

        );
        Comment comment = mapToComment(commentDto);
        comment.setPost(post);
        Comment save = commentRepo.save(comment);

        Comment newComment = commentRepo.save(comment);
        return mapToDto(newComment);
    }


    Comment mapToComment(CommentDto commentDto){
        Comment comment = new Comment();
        comment.setName(commentDto.getName());
        comment.setBody(commentDto.getBody());
        comment.setEmail(commentDto.getEmail());
        return comment;
    }

    CommentDto mapToDto(Comment comment){
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setName(comment.getName());
        commentDto.setBody(comment.getBody());
        commentDto.setEmail(comment.getEmail());
        return commentDto;

    }
}

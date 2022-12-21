package com.myblog.rest.api.Service;

import com.myblog.rest.api.Payload.CommentDto;

public interface CommentService {

    CommentDto createCommentDto(long postId,CommentDto commentDto);
}
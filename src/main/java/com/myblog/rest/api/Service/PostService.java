package com.myblog.rest.api.Service;

import com.myblog.rest.api.Payload.PostDto;
import com.myblog.rest.api.Payload.PostResponse;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto);
    public PostResponse getAllPost(int pageNo, int pageSize, String sortBy, String sortDir);


    PostDto getPostById(long id);


    PostDto updatePost(PostDto postDto, long id);

    void deletePost(long id);
}

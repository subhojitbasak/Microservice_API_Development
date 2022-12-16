package com.myblog.rest.api.Service;

import com.myblog.rest.api.Payload.PostDto;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto);
    public List<PostDto> getAllPost(int pageNo, int pageSize);


    PostDto getPostById(long id);


    PostDto updatePost(PostDto postDto, long id);

    void deletePost(long id);
}

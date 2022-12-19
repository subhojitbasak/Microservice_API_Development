package com.myblog.rest.api.Controller;

import com.myblog.rest.api.Payload.PostDto;
import com.myblog.rest.api.Payload.PostResponse;
import com.myblog.rest.api.Service.PostService;
import com.myblog.rest.api.util.AppConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private PostService postService;

    public PostController(PostService postService){
        this.postService = postService;
    }
    //Creation of posts
    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
      return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }
    //to retrieve all posts
    //pagination
    //localhost:8080/api/posts?pageNo=0&pageSize=5&sortBy=title&sortDir=desc
    @GetMapping
    public PostResponse getAllPosts(
            @RequestParam (value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false ) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE,required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false)String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIR, required = false)String sortDir
    ){
      //  List<PostDto> postDto = postService.getAllPost();
        return postService.getAllPost(pageNo, pageSize,sortBy,sortDir);
    }
    //to retrieve post's based on id
    @GetMapping("/{id}")
    public ResponseEntity<PostDto>  getPostById(@PathVariable("id") long id){
        return ResponseEntity.ok( postService.getPostById(id));
    }
    //to update based on id
    @PutMapping("/updatePost/{id}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto,@PathVariable("id") long id){
        PostDto dto = postService.updatePost(postDto, id);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
    //to delete based on id
    @DeleteMapping("/deletePost/{id}")
    public ResponseEntity<String> deletePost(@PathVariable("id") long id){
        postService.deletePost(id);
        return new ResponseEntity<>("Post entity deleted sucessfully ",HttpStatus.OK);
    }


}

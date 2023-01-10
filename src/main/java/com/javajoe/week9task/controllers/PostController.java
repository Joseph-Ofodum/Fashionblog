package com.javajoe.week9task.controllers;

import com.javajoe.week9task.dto.CommentResponseDto;
import com.javajoe.week9task.dto.PostDto;
import com.javajoe.week9task.dto.PostResponseDto;
import com.javajoe.week9task.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/post")
@RequiredArgsConstructor
@RestController
public class PostController {
    private final PostService postService;

 @PostMapping("/createPost")
    public ResponseEntity<String> createPost(@RequestBody PostDto  postDto){
     postService.createPost(postDto);
     return new ResponseEntity<>("Successfully Posted", HttpStatus.CREATED);
 }
 //TODO learn how to delete with dto too not just by ID
 @DeleteMapping("/delete/{postid}")
    public ResponseEntity<String> deletePost( @PathVariable Long postId){
      postService.deletePost(postId);
      return new ResponseEntity<>("Post deleted successfully", HttpStatus.ACCEPTED);
 }

 @GetMapping("/findpost/{post_id}")
    public ResponseEntity<PostResponseDto> getpost( @PathVariable Long postId){
     return new ResponseEntity<>(postService.getPost(postId),HttpStatus.OK);
 }

 @GetMapping("/getAllPosts")
    public ResponseEntity<List<PostResponseDto>> getAllPosts(){
     List<PostResponseDto> postResponseDtoList = postService.getAllPosts();
     return new ResponseEntity<>(postResponseDtoList, HttpStatus.OK);
 }
}

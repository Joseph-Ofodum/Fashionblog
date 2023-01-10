package com.javajoe.week9task.services;

import com.javajoe.week9task.dto.PostDto;
import com.javajoe.week9task.dto.PostResponseDto;
import com.javajoe.week9task.entities.PostEntity;

import java.util.List;

public interface PostService {
    PostEntity createPost(PostDto postDto);

    void deletePost(Long postId);

    PostResponseDto getPost(Long postId);

    List<PostResponseDto> getAllPosts();

}

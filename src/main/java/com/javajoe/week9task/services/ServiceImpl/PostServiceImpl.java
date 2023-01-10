package com.javajoe.week9task.services.ServiceImpl;

import com.javajoe.week9task.dto.PostDto;
import com.javajoe.week9task.dto.PostResponseDto;
import com.javajoe.week9task.entities.PostEntity;
import com.javajoe.week9task.exception.ResourceNotFoundException;
import com.javajoe.week9task.repositories.PostRepository;
import com.javajoe.week9task.services.PostService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;


    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
//TODO validation for posts
    @Override
    public PostEntity createPost(PostDto postDto) {
        PostEntity post = new PostEntity();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setCategoryOfDesign(post.getCategoryOfDesign());
        post.setImage(post.getImage());
        return postRepository.save(post);
    }

    @Override
    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }

    @Override
    public PostResponseDto getPost(Long postId) {
        PostEntity post = postRepository.findById(postId).
                orElseThrow(()-> new ResourceNotFoundException("Post not found", "Post might have been deleted or does not exist"));
        PostResponseDto postResponseDto= new PostResponseDto();
        postResponseDto.setPostId(post.getId());
        postResponseDto.setTitle(post.getTitle());
        postResponseDto.setDescription(post.getDescription());
        postResponseDto.setCategoryOfDesign(post.getCategoryOfDesign());
        postResponseDto.setLocalDateTime(post.getDateCreated());

        return postResponseDto;
    }

    //TODO ask Augustine how to handle exception here
    @Override
    public List<PostResponseDto> getAllPosts() {
        List<PostEntity> posts = postRepository.findAll();
        List<PostResponseDto> postResponseDtoList = new ArrayList<>();
        posts.forEach(postEntity ->{
            PostResponseDto postResponseDto= new PostResponseDto();
            postResponseDto.setPostId(postEntity.getId());
            postResponseDto.setTitle(postEntity.getTitle());
            postResponseDto.setDescription(postEntity.getDescription());
            postResponseDto.setCategoryOfDesign(postEntity.getCategoryOfDesign());
            postResponseDto.setLocalDateTime(postEntity.getDateCreated());
            postResponseDtoList.add(postResponseDto);
        });
        return postResponseDtoList;
    }
}

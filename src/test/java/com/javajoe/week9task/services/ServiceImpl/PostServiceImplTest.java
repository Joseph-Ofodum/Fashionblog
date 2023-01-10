package com.javajoe.week9task.services.ServiceImpl;

import com.javajoe.week9task.entities.PostEntity;
import com.javajoe.week9task.repositories.PostRepository;
import com.javajoe.week9task.services.PostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PostServiceImplTest {
    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private PostServiceImpl postService;

    PostEntity post;

    @BeforeEach
    void setUp() {
        post= new PostEntity();
        post.setTitle("Deception");
        post.setDescription("women alure");
        post.setCategoryOfDesign("crop top");
        post.setImage("www.godsoffashion");
    }

    @Test
    void createPost() {
    }

    @Test
    void deletePost() {
    }

    @Test
    void getPost() {
    }

    @Test
    void getAllPosts() {
    }
}
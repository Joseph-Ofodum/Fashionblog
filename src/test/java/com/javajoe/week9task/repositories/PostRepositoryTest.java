package com.javajoe.week9task.repositories;

import com.javajoe.week9task.entities.PostEntity;
import com.javajoe.week9task.entities.UserModel;
import com.javajoe.week9task.enums.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class PostRepositoryTest {
    @Autowired
    PostRepository postRepository;

    PostEntity post;


    @BeforeEach
    void setUp() {
        post = new PostEntity();
        post.setTitle("Deception");
        post.setDescription("women alure");
        post.setCategoryOfDesign("crop top");
        post.setImage("www.godsoffashion");

    }

    @Test
    void savePost(){
        PostEntity postEntity = postRepository.save(post);
        assertThat(postEntity).isNotNull();
        assertThat(postEntity.getTitle()).isEqualTo(post.getTitle());

    }
}
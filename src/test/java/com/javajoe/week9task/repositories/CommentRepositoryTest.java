package com.javajoe.week9task.repositories;

import com.javajoe.week9task.entities.Comment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CommentRepositoryTest {
    @Autowired
    CommentRepository commentRepository;

    Comment comment;


    @BeforeEach
    void setUp() {
        comment = new Comment();
        comment.setUserName("javaJoe");
        comment.setDescription("ladies allure");
        comment.setEmail("@okwuibe@gmail.com");
    }

    @Test
    void saveComment(){
        Comment comment1 = commentRepository.save(comment);
        assertThat(comment1).isNotNull();
        assertThat(comment1.getEmail()).isEqualTo(comment.getEmail());
    }
}
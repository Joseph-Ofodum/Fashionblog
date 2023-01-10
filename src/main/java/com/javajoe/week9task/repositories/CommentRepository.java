package com.javajoe.week9task.repositories;

import com.javajoe.week9task.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}

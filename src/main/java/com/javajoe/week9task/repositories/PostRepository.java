package com.javajoe.week9task.repositories;

import com.javajoe.week9task.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
}

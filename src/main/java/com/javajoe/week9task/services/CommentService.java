package com.javajoe.week9task.services;

import com.javajoe.week9task.dto.CommentDto;
import com.javajoe.week9task.dto.CommentResponseDto;
import com.javajoe.week9task.entities.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    Comment createComment(CommentDto commentDto);

    void deleteComment(Long commentId);

    CommentResponseDto getComment(Long CommentId);

    List<CommentResponseDto> getAllComments();
}

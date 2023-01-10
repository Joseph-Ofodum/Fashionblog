package com.javajoe.week9task.services.ServiceImpl;

import com.javajoe.week9task.dto.CommentDto;
import com.javajoe.week9task.dto.CommentResponseDto;
import com.javajoe.week9task.entities.Comment;
import com.javajoe.week9task.exception.ResourceNotFoundException;
import com.javajoe.week9task.repositories.CommentRepository;
import com.javajoe.week9task.services.CommentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    CommentServiceImpl(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }
    //TODO validation
    @Override
    public Comment createComment(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setUserName(commentDto.getUserName());
        comment.setDescription(commentDto.getDescription());
        comment.setEmail(commentDto.getEmail());

        return commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);

    }

    @Override
    public CommentResponseDto getComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId).
                orElseThrow(()-> new ResourceNotFoundException("Comment not found", "Please Check the ID"));
        CommentResponseDto commentResponseDto = new CommentResponseDto();
        commentResponseDto.setCommentId(comment.getId());
        commentResponseDto.setUserName(comment.getUserName());
        commentResponseDto.setDescription(comment.getDescription());


        return commentResponseDto;
    }

    @Override
    public List<CommentResponseDto> getAllComments() {
        List<Comment> comments = commentRepository.findAll();
        List<CommentResponseDto> commentResponseDtoList= new ArrayList<>();
        comments.forEach(comment ->{
            CommentResponseDto commentResponseDto = new CommentResponseDto();
            commentResponseDto.setCommentId(comment.getId());
            commentResponseDto.setUserName(comment.getUserName());
            commentResponseDto.setDescription(comment.getDescription());
            commentResponseDtoList.add(commentResponseDto);

        });
        return commentResponseDtoList;
    }
}

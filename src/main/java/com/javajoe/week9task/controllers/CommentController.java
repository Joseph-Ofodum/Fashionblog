package com.javajoe.week9task.controllers;

import com.javajoe.week9task.dto.CommentDto;
import com.javajoe.week9task.dto.CommentResponseDto;
import com.javajoe.week9task.dto.PostResponseDto;
import com.javajoe.week9task.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")

public class CommentController {
private final CommentService commentService;

@PostMapping("/createComment")
    public ResponseEntity<String> createComment(@RequestBody CommentDto commentDto){
    commentService.createComment(commentDto);
    return new ResponseEntity<>("Comment posted successfully", HttpStatus.CREATED);
}

@DeleteMapping("/delete/{comment_Id}")
    public ResponseEntity<String> deleteComment(@PathVariable Long id){
    commentService.deleteComment(id);
    return new ResponseEntity<>("Comment deleted successfully", HttpStatus.ACCEPTED);
}

@GetMapping("/findcomment/{comment_id}")
    public ResponseEntity<CommentResponseDto> getComment(@PathVariable Long id){
    return new ResponseEntity<>(commentService.getComment(id),HttpStatus.OK);
}
@GetMapping("/allcomment")
    public ResponseEntity<List<CommentResponseDto>> getAllComments(){
    List<CommentResponseDto> commentResponseDtoList = commentService.getAllComments();
    return new ResponseEntity<>(commentResponseDtoList, HttpStatus.OK);
}

}


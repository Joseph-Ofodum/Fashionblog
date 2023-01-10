package com.javajoe.week9task.dto;


import lombok.Data;

@Data
public class CommentResponseDto {
    private Long commentId;
    private String description;
    private String userName;
}

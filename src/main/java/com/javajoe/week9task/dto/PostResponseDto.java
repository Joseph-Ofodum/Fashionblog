package com.javajoe.week9task.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostResponseDto {
    private Long postId;
   // private Like postLike;
    private String title;
    private String description;
    private String categoryOfDesign;
    private LocalDateTime localDateTime;

}

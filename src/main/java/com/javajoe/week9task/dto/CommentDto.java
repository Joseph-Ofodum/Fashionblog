package com.javajoe.week9task.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto{
    @NonNull
    private String UserName;
    private String description;
    @NonNull
    private String email;

}

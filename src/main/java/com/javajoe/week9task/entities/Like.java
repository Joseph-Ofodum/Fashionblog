package com.javajoe.week9task.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Table(name="like_table")
public class Like extends BaseClass{
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserModel userModel;

    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    private PostEntity post;

    @ManyToOne
    @JoinColumn(name="comment_id", referencedColumnName = "id")
    private Comment comment;
}



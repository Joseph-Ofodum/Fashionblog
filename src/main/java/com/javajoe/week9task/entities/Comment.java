package com.javajoe.week9task.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Comment extends BaseClass{

    @Column(nullable = false, length = 25)
    private String userName;
   // private Long postId;
    private String Description;
    @Column(nullable = false, unique = true)
    private String email;
    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName= "id")
    private UserModel userModel;
    @ManyToOne
    @JoinColumn(name = "post_comment_id", referencedColumnName = "id")
    private PostEntity post;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Like> like;


}

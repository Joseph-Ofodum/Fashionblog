package com.javajoe.week9task.entities;

import com.javajoe.week9task.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserModel extends BaseClass{

    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    private String phoneNumber;
    @Column(nullable = false, unique = true)
    private  String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private Role role;
//    @OneToMany
//    @JoinColumn(name="user_post")
//    private List<PostEntity> postList;
//    @OneToMany
//
//    private List<Comment> comments;
//    @OneToMany
//    private List<Like> likes;
}

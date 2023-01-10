package com.javajoe.week9task.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PostEntity extends BaseClass {
    @Column(nullable = false, length = 50)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false, length = 50)
    private String categoryOfDesign;
    private String image;
    @ManyToOne
    @JoinColumn(name="post_id")
    private UserModel userModel;


    @JsonIgnore
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Like> like;
}


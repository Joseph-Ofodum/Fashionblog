package com.javajoe.week9task.controllers;

import com.javajoe.week9task.services.LikeService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/like")
public class LikeController {
    private final LikeService likeService;

    @PostMapping("/{post_id}")
    public String postLike(@PathVariable("post_id") Long postId){
        likeService.postLike(postId);
        return "Post Liked";
    }
    @GetMapping("/noOfLikes/{post_id}")
    public Integer noOfLikesOnPOst(@PathVariable("post_id") Long postId){
        return likeService.noOfLikesOnPost(postId);
    }

    @PostMapping("/{comment_id}")
    public String commentLike(@PathVariable("comment_id") Long commentId){
        likeService.commentLike(commentId);
        return "comment Liked";
    }

    @GetMapping("/noOfLikes{comment_id}")
    public Integer noOfLikesOnComment(@PathVariable("comment_id") Long commentId){
        return likeService.noOfLikesOnComment(commentId);
    }

}

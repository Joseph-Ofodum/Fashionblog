package com.javajoe.week9task.services;

import com.javajoe.week9task.entities.Comment;
import com.javajoe.week9task.entities.PostEntity;


public interface LikeService{
  PostEntity postLike(Long postId);
  int noOfLikesOnPost(Long postId);
  Comment commentLike(Long commentId);
  Integer noOfLikesOnComment(Long commentId);

}

package com.javajoe.week9task.services.ServiceImpl;


import com.javajoe.week9task.entities.Comment;
import com.javajoe.week9task.entities.Like;
import com.javajoe.week9task.entities.PostEntity;
import com.javajoe.week9task.exception.ResourceNotFoundException;
import com.javajoe.week9task.repositories.CommentRepository;
import com.javajoe.week9task.repositories.PostRepository;
import com.javajoe.week9task.services.LikeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LikeServiceImpl implements LikeService {
    private final PostRepository postRepository;

    private final CommentRepository commentRepository;

    @Override
    public PostEntity postLike(Long postId) {
        PostEntity post = postRepository.findById(postId).
                orElseThrow(()-> new ResourceNotFoundException("Post not liked yet"));
        Like like =Like.builder()
                .post(post)
                .userModel(null)
                .build();
        post.getLike().add(like);
        postRepository.save(post);
        return post;
    }

    @Override
    public int noOfLikesOnPost(Long postId) {
        PostEntity post = postRepository.findById(postId).
                orElseThrow(()-> new ResourceNotFoundException("no Likes yet"));
        return post.getLike().size();
    }

    @Override
    public Comment commentLike(Long commentId) {
        Comment comment = commentRepository.findById(commentId).
                orElseThrow(()-> new ResourceNotFoundException("Comment not Liked yet"));
        Like like = Like.builder()
                .comment(comment)
                .userModel(null)
                .build();
          comment.getLike().add(like);
          commentRepository.save(comment);
          return comment;
    }

    @Override
    public Integer noOfLikesOnComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId).
                orElseThrow(()-> new ResourceNotFoundException("no likes yet"));
        return comment.getLike().size();
    }
}

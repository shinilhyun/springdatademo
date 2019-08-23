package me.shin.springdatademo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentRepository extends MyRepository<Comment, Long> {

    Page<Comment> findByCommentContainsIgnoreCase(String keyword, Pageable pageable);

}

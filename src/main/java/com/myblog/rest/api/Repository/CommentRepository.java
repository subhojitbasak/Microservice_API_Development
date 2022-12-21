package com.myblog.rest.api.Repository;

import com.myblog.rest.api.Entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}

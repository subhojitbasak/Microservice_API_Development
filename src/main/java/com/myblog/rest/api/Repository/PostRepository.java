package com.myblog.rest.api.Repository;

import com.myblog.rest.api.Entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}

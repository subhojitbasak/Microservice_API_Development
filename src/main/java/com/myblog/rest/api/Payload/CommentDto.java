package com.myblog.rest.api.Payload;

import com.myblog.rest.api.Entities.Post;
import lombok.Data;

import javax.persistence.*;

@Data
public class CommentDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String body;

    private String email;

    private String name;
}

package com.myblog.rest.api.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "comments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String body;

    private String email;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)// here many comment have one post so we go for manytoone.
    @JoinColumn(name = "post_id",nullable = false) //in this comment table JoinColumn used to create foreign key. Here post_id is
    //the foreign key for comments table which is present in post table.
    private Post post;



}

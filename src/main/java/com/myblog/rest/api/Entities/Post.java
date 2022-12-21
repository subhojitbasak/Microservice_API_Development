package com.myblog.rest.api.Entities;

import ch.qos.logback.classic.db.names.ColumnName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "posts",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})}
        )
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "description", nullable = false)
    private String description;

    @Lob
    @Column(name = "content", nullable = false)
    private String content;

    // cascade used to provide -> changes in parent class will also reflect in child class too
    //orphan is used to provide -> when its parent table is deleted then its child also deleted.e.g. if a video has
    //multiple comments once the video gets deleted its all comments should all deleted.
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL,orphanRemoval = true)
    Set<Comment> comments = new HashSet<>();



}

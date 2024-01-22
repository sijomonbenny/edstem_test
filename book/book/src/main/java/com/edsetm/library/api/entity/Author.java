package com.edsetm.library.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * Model for Storing Author Details
 */
@Entity(name = "author")
public class Author {

    @Id
    int id;

    @Column(name = "author_name")
    String authorName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}

package com.example.mypasteapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
public class Comment {
    @Id
    private int id;
    private String content;
    @CreationTimestamp()
    private Instant createdOn;
    @ManyToOne
    private User author;
    @ManyToOne
    private MyPaste paste;

    public Comment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public MyPaste getPaste() {
        return paste;
    }

    public void setPaste(MyPaste paste) {
        this.paste = paste;
    }
}

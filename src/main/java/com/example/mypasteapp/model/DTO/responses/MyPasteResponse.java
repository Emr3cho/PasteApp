package com.example.mypasteapp.model.DTO.responses;

import com.example.mypasteapp.model.User;

import java.time.Instant;
import java.util.UUID;

public class MyPasteResponse {
    private UUID id;
    private String title;
    private String content;
    private Instant createdOn;
    private Instant lastUpdatedOn;
    private int userId;

    public MyPasteResponse(UUID id, String title, String content, Instant createdOn, Instant lastUpdatedOn, int userId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdOn = createdOn;
        this.lastUpdatedOn = lastUpdatedOn;
        this.userId = userId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Instant getLastUpdatedOn() {
        return lastUpdatedOn;
    }

    public void setLastUpdatedOn(Instant lastUpdatedOn) {
        this.lastUpdatedOn = lastUpdatedOn;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}

package com.example.mypasteapp.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.UpdateTimestamp;
import com.example.mypasteapp.model.User;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class MyPaste {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private String title;
	private String content;
	@CreationTimestamp()
	private Instant createdOn;
	@UpdateTimestamp()
	private Instant lastUpdatedOn;
	@ManyToOne
	private User user;
	@OneToMany
	List<Comment> comments = new ArrayList<>();

	@ManyToMany(mappedBy = "favorites")
	private List<User> favoritesOwners;

	public MyPaste() {
	}

	public MyPaste(String title, String content, User user) {
		this.title = title;
		this.content = content;
		this.user = user;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<User> getFavoritesOwners() {
		return favoritesOwners;
	}

	public void setFavoritesOwners(List<User> favoritesOwners) {
		this.favoritesOwners = favoritesOwners;
	}
}

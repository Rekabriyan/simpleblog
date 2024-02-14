package com.rekabriyan.simpleblog.vo;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "comment")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="postId")
	private Long postId;

	@Column(name="user") 
	private String user;

	@Column(name="comment")
	private String comment;

	@Column(name="regDate")
	private Date regDate;

	public Comment() {
	}
	
	public Comment(Long postId, String user, String comment) {
		this.postId = postId;
		this.user = user;
		this.comment = comment;
		this.regDate = new Date();
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) { 
		this.id = id;
	}

	public Long getPostId() { 
		return postId;
	}

	public void setPostId (Long postId) { 
		this.postId = postId;
	}
	
	public String getUser() { 
		return user;
	}

	public void setUser(String user) { 
		this.user = user;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) { 
		this.comment = comment;
	}
	
	public Date getregDate() { 
		return regDate;
	}
	
	public void setRegDate(Date regDate) { 
		this.regDate = regDate;
	}
}
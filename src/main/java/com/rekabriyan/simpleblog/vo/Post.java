package com.rekabriyan.simpleblog.vo;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "post")
public class Post {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="user")
	private String user;
	
	@Column(name="title")
	private String title;
	
	@Column(name="content")
	private String content;
	
	@Column(name="regDate")
	private Date regDate;
	
	@Column(name="updtDate")
	private Date updtDate;
	
	public Post() {
	}
	
	public Post(Long id, String user, String title, String content) {
	    super();
	    this.id = id;
	    this.user = user;
	    this.title = title;
	    this.content = content;
	    this.regDate = new Date();
	    this.updtDate = new Date();
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
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
	

	public Date getRegDate() {
		return regDate;
	}
	
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	public Date getUpdtDate() {
		return updtDate;
	}
	
	public void setUpdtDate(Date updtDate) {
		this.updtDate = updtDate;
	}
	
	public Post(String user, String title, String content) {
		this.user = user;
		this.title = title;
		this.content = content;
		this.regDate = new Date();
		this.updtDate = new Date ();
	}
	
	public Post(Long id, String title, String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
	}
}

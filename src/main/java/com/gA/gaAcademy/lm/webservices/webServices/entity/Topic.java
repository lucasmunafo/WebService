package com.gA.gaAcademy.lm.webservices.webServices.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Topic {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name ="title")
	private String title;
	
	@Column(name ="datePost")
	private Date datePost;
	
	@Column(name ="description")
	private String description;
	
	@Column(name ="author")
	private String author;
	
	public Topic() {}

	public Topic(String title, Date datePost, String description, String author) {
		super();
		this.title = title;
		this.datePost = datePost;
		this.description = description;
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDatePost() {
		return datePost;
	}

	public void setDatePost(Date datePost) {
		this.datePost = datePost;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getId() {
		return id;
	}
	
	
	
	
}

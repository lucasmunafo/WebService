package com.gA.gaAcademy.lm.webservices.webServices.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Reply {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idReply;

	@Column(name ="title")
	private String title;
	
	@Column(name ="datePost")
	private Date datePost;
	
	@Column(name ="description")
	private String description;
	
	@Column(name ="author")
	private String author;
	
	@Column(name ="parentId")
	private int parentId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "topic", nullable = false)
	private Topic topic;
	
	
	
	
	public Reply() {}


	public Reply(Date datePost, String description, String author, String title, Topic topic) {
		super();
		this.title = title;
		this.datePost = datePost;
		this.description = description;
		this.author = author;
		this.topic = topic;
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
		return idReply;
	}


	public Topic getTopic() {
		return topic;
	}
	


	public void setTopic(Topic topic) {
		this.topic = topic;
	}


	public int getParentId() {
		return parentId;
	}


	public void setParentId(int parentId) {
		this.parentId = parentId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
	
}



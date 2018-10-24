package com.gA.gaAcademy.lm.webservices.webServices.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Reply {

	@Id
	@GeneratedValue
	private int idReply;
	
	@Column(name ="datePost")
	private Date datePost;
	
	@Column(name ="description")
	private String description;
	
	@Column(name ="author")
	private String author;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "replyId", referencedColumnName="id")
	private Topic topic;
	
	
	public Reply() {}


	public Reply(Date datePost, String description, String author) {
		super();
		this.datePost = datePost;
		this.description = description;
		this.author = author;
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
	
	
	
}



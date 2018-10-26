package com.gA.gaAcademy.lm.webservices.webServices.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.CreatedDate;

@Entity
public class Topic {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name ="title")
	private String title;
	
	@Column(name ="datePost")
	@CreatedDate
	private Date datePost;
	
	@Column(name ="description")
	private String description;
	
	@Column(name ="author")
	private int author;
	
	@Column(name = "deleted")
	private boolean deleted;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "topic")
	private List<Reply> replyList = new ArrayList<Reply>();
	
	
	public Topic() {}

	public Topic(String title, Date datePost, String description, int author, boolean deleted) {
		super();
		this.title = title;
		this.datePost = datePost;
		this.description = description;
		this.author = author;
		this.deleted = deleted;
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

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public void delete() {
		this.deleted = true;
	}

	public List<Reply> getReplyList() {
		return replyList;
	}
/*
	public void setReplyList(List<Reply> replyList) {
		this.replyList = replyList;
	}
	*/
	
	public void addReply(Reply reply) {
		replyList.add(reply);
	}
	
	
	
}

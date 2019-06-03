package com.collaboration.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table
@SequenceGenerator(name="myforumcommentseq",sequenceName="myforumcommentseq")
public class ForumComment {
     
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="myforumcommentseq")
	int commentId;
	int forumId;
	String commentText;
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-MM-yyyy")
	Date commentDate;
		String username;
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public int getForumId() {
		return forumId;
	}
	public void setForumId(int forumId) {
		this.forumId = forumId;
	}
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}

package com.stories.Models;

import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@NoArgsConstructor
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;

	public String content;
		
	public Timestamp timeComment;
	
	
	  public Comment(String content, Post post ,Author author) {
	      	this.content = content ;
	      	this.CPost = post ;
	      	this.CBlogger = author ;
	        this.timeComment = new Timestamp(System.currentTimeMillis());
	    }
	

	 @JsonIgnore
	 @ManyToOne
	 @JoinColumn(name="idPost")
     private Post CPost;

	
	 @ManyToOne
	 @JoinColumn(name="idAuthor")
     private Author CBlogger;

}

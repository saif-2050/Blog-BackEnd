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
@Data
@Entity
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	
	
	public String content;
		
	public Timestamp timeComment;
	
	
	
	public void setTimePostedNow() {
        this.timeComment = new Timestamp(System.currentTimeMillis());
    }
	
	 @ManyToOne
	 @JoinColumn(name="idPost")
     private Post CPost;

	
	 @ManyToOne
	 @JoinColumn(name="idAuthor")
     private Author CBlogger;

}

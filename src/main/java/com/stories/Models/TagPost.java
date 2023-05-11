package com.stories.Models;


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
public class TagPost {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	
	@JsonIgnore
	@ManyToOne 
	@JoinColumn (name="idPost")
	private Post post;
	
	@JsonIgnore
	@ManyToOne 
	@JoinColumn (name="idTags")
	private Tags tag;
}

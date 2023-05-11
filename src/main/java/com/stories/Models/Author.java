package com.stories.Models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
@Data
@Entity
public class Author {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	public int id ;
	public String username ;
	public String email ;
	public String password ;
	public String imageurl ;
	
	@JsonIgnore
	@OneToMany(mappedBy="blogger")
	private List<Post> ListP = new ArrayList<Post>();
	
	
	@JsonIgnore
	@OneToMany(mappedBy="CBlogger")
	private List<Comment> ListC = new ArrayList<Comment>();
}

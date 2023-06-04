package com.stories.Models;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stories.Repository.AuthorRepository;
import com.stories.Repository.CommentRepository;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Post{
	
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	public int id ;
	
	public String title ; 	
	
	public String content;
	
	public String postimageurl;
	
	public Timestamp timePosted;
	
	public int nbrseeing ;
	
	public void updateNumberSee() {
		this.nbrseeing ++ ;
	}
	
	  public Post(String title, String content, String img ,Author author) {
	        this.title = title;
	        this.content = content;
	        this.blogger = author;
	        this.postimageurl = img ;
	        this.timePosted = new Timestamp(System.currentTimeMillis());
	    }
	
	
	 
	 @ManyToOne
	 @JoinColumn(name="idAuthor")
     private Author blogger;
	 
	 
	 @OneToMany(mappedBy="CPost")
	 private List<Comment> ListC = new ArrayList<Comment>(); 
	 
	 
	 @OneToMany(mappedBy="post" , cascade = CascadeType.PERSIST)
	 private List<TagPost> ListPost = new ArrayList<TagPost>();
	
	  @Transient
	  private List<String> tagNames;

	    public List<String> getTagNames() {
	        if (tagNames == null) {
	            tagNames = ListPost.stream().map(tagPost -> tagPost.getTag().getName()).collect(Collectors.toList());
	        }
	        return tagNames;
	    }
}

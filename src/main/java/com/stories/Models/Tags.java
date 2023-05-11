package com.stories.Models;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
@Data
@Entity


public class Tags {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	
    private String name;
    
    @JsonIgnore
    @OneToMany(mappedBy="tag" ,  cascade = CascadeType.PERSIST)
	private List<TagPost> ListTag = new ArrayList<TagPost>();

}

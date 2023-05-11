package com.stories.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stories.Models.Tags;
import com.stories.Repository.TagRepository;

@Service
public class TagService {

	@Autowired
	private TagRepository tagRepository ; 
	
	
	
	public List<Tags> getAllTag(){
		return tagRepository.findAll() ;
	
}
}

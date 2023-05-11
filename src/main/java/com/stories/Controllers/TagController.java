package com.stories.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stories.Models.Tags;
import com.stories.Services.TagService;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Tag")
@RestController
public class TagController {

	@Autowired
	private TagService tagservice;
	
	@GetMapping("/getAll")
	@ResponseBody
	public List<Tags> GetAll() {
		return tagservice.getAllTag();
		
	}
}

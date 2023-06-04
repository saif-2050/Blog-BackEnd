package com.stories.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stories.Models.Comment;
import com.stories.Requests.CommentRequest;
import com.stories.Requests.PostRequest;
import com.stories.Services.CommentService;
import com.stories.Services.PostService;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Comment")
@RestController
public class CommentController {

	
	@Autowired
	private CommentService comservice;
	
	
	@PostMapping("/add")
	@ResponseBody	
	public ResponseEntity<?> save(@RequestBody CommentRequest com) {
		return comservice.add(com);
	}
}

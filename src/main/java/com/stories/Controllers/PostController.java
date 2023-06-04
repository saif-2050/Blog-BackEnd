package com.stories.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stories.Models.Post;
import com.stories.Requests.PostRequest;
import com.stories.Services.PostService;
import com.stories.Requests.postResponse;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Post")
@RestController
public class PostController {

	
	@Autowired
	private PostService postservice;
	
	@GetMapping("/getPostByAuthorId/{id}")
	@ResponseBody
	public List<Post> GetPostByAuthorId(@PathVariable("id") int id) {
		return postservice.getPostsByAuthorId(id);
		
	}
	
	@GetMapping("/getById/{id}")
	@ResponseBody
	public Optional <postResponse> GetPostById(@PathVariable("id") int id) {
		return postservice.getPostById(id);
		
	}
	
	@GetMapping("/updateSeePost/{id}")
	@ResponseBody
	public Optional <Post> UpdatePostSee(@PathVariable("id") int id) {
		return postservice.UpdatePostById(id);
		
	}
	
	@GetMapping("/getAll")
	@ResponseBody
	public List<Post> GetAll() {
		return postservice.getAllPost();
		
	}
	
	
	@PutMapping("/update/{id}")
	@ResponseBody	
	public ResponseEntity<?> updatePost(@PathVariable("id") int id , @RequestBody PostRequest P) {
		return postservice.update(id,P);
	}
	
	@DeleteMapping("/delete/{id}")
	@ResponseBody	
	public ResponseEntity<?> DeletePost(@PathVariable("id") int id) {
		return postservice.delete(id);
	}
	
	@PostMapping("/add")
	@ResponseBody	
	public ResponseEntity<?> save(@RequestBody PostRequest P) {
		return postservice.add(P);
	}
}

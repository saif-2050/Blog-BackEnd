package com.stories.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.stories.Models.Post;
import com.stories.Models.Author;
import com.stories.Models.Comment;
import com.stories.Repository.AuthorRepository;
import com.stories.Repository.CommentRepository;
import com.stories.Repository.PostRepository;
import com.stories.Requests.CommentRequest;

@Service
public class CommentService {
	@Autowired
	private AuthorRepository autherrepo ; 
	@Autowired
	private PostRepository postrepo ; 
	@Autowired
	private CommentRepository comRepository ;
	
	public ResponseEntity<?> add(CommentRequest com) {
		Author user = autherrepo.findById(com.getAuthorID()).orElse(null);
		Post post = postrepo.findById(com.getPostID()).orElse(null);
		if (user!= null && post!= null) {
			Comment comt = new Comment(com.getContent(), post ,user);
			comRepository.save(comt) ;
		   return ResponseEntity.ok("Comment added");
		}else {
			  return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post or Author not found");
		}
		
	   
	}
}

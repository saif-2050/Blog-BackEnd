package com.stories.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import com.stories.Models.Author;
import com.stories.Models.Post;
import com.stories.Models.Tags;
import com.stories.Models.TagPost;
import com.stories.Repository.AuthorRepository;
import com.stories.Repository.PostRepository;
import com.stories.Repository.TagPostRepository;
import com.stories.Repository.TagRepository;
import com.stories.Requests.PostRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class PostService {
	@Autowired
	private AuthorRepository autherrepo ; 
	@Autowired
	private PostRepository postrepo ; 
	@Autowired
	private TagPostRepository tagPostRepository ; 
	
	@Autowired
	private TagRepository tagRepository ; 
	
	
	
	public List<Post> getAllPost(){
		return postrepo.findAll() ;
	}
	
	public Optional <Post> getPostById(int id) {
        return postrepo.findById(id);

    }
	
	
	

	
	
	
	public ResponseEntity<?> update(int postId, PostRequest updatedPost) {
	    // Find the post to be updated
	    Post existingPost = postrepo.findById(postId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found"));

	    // Update the post data
	    existingPost.setTitle(updatedPost.getTitle());
	    existingPost.setContent(updatedPost.getContent());
	    existingPost.setPostimageurl(updatedPost.getPostimageurl());

	    // Update the tags associated with the post
	    List<Tags> tags = new ArrayList<>();
	    for (Integer tagId : updatedPost.getTagIds()) {
	        Tags tag = tagRepository.findById(tagId).orElseThrow(() -> new RuntimeException("No Tags !"));
	        tags.add(tag);
	    }

	    // Remove the existing tag-post associations
	    List<TagPost> existingTagPosts = tagPostRepository.findByPost(existingPost);
	    existingTagPosts.forEach(tagPostRepository::delete);

	    // Create new tag-post associations
	    for (Tags tag : tags) {
	        TagPost tagPost = new TagPost();
	        tagPost.setPost(existingPost);
	        tagPost.setTag(tag);
	        existingPost.getListPost().add(tagPost);
	        tag.getListTag().add(tagPost);
	        tagPostRepository.save(tagPost);
	        tagRepository.save(tag);
	    }

	    // Save the updated post
	    postrepo.save(existingPost);

	    return ResponseEntity.ok("Post updated successfully");
	}


	
	public ResponseEntity<?> add(PostRequest P) {
		autherrepo.findById(P.getAuthorId())
	    .ifPresentOrElse(author -> {
	    	Post newp = new Post(P.getTitle(),P.getContent(),P.getPostimageurl() ,author);
	    	List<Tags> tags = new ArrayList<>();
	        for (Integer tagId : P.getTagIds()) {
	            Tags tag = tagRepository.findById(tagId).orElseThrow(() -> new RuntimeException("No Tags !"));
	            tags.add(tag);
	        }
	        for (Tags tag : tags) {
	        	    TagPost tagPost = new TagPost();
	        	    tagPost.setPost(newp);
	        	    tagPost.setTag(tag);
	        	    newp.getListPost().add(tagPost);
	        	    tag.getListTag().add(tagPost);
	        	    //postrepo.save(newp);
	        	    //tagRepository.save(tag);
	        	   // tagPostRepository.save(tagPost);
	        	    
	        	}

	        	Post savedPost = postrepo.save(newp);	    	
	    },
	     () -> {throw new ResponseStatusException(404,"Author does not Exist", null);});
	    
	    return ResponseEntity.ok("Post Ajoutee avec succes");
	}
}

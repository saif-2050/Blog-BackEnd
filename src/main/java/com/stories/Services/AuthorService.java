package com.stories.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.stories.Models.Author;
import com.stories.Repository.AuthorRepository;
import com.stories.Requests.AuthentificationRequest;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepository autherrepo ; 
	  public  ResponseEntity<?>  authenticate(AuthentificationRequest request) {
		  Author user = autherrepo.findByEmail(request.getEmail()).orElse(null);
				  	  
				  if (user != null) {
				        if (user.getPassword().equals(request.getPassword())) {
				            return ResponseEntity.ok(user);
				        } else {
				            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid password");
				        }
				    } else {
				        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email not found");
				    }
				
	    }
}

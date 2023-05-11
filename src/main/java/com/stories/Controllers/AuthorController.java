package com.stories.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stories.Models.Author;
import com.stories.Requests.AuthentificationRequest;
import com.stories.Services.AuthorService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AuthorController {

	
	@Autowired
	private AuthorService authservice;
	
	 @PostMapping("/login")
    public ResponseEntity<?>  loginUser(@RequestBody AuthentificationRequest request) {
		return authservice.authenticate(request);
        
    }

}

package com.stories.Services;
import java.security.Key;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.stories.Models.Author;
import com.stories.Models.Post;
import com.stories.Repository.AuthorRepository;
import com.stories.Requests.AuthentificationRequest;
import com.stories.Requests.postResponse;
import java.security.Key;
import java.util.Base64;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.Keys;

@Service
public class AuthorService {
	  byte[] keyBytes = Keys.secretKeyFor(SignatureAlgorithm.HS256).getEncoded();
      String encodedKey = Base64.getEncoder().encodeToString(keyBytes);
	@Autowired
	private AuthorRepository autherrepo ; 
	
	public Optional<Author> findAuthorByid(int id) {
		Author user = autherrepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Author not found"));
		return Optional.of(user) ;
	}
	
	
	
	 private final String secretKey = encodedKey; // Replace with your own secret key

	    public ResponseEntity<?> authenticate(AuthentificationRequest request) {
	        Author user = autherrepo.findByEmail(request.getEmail()).orElse(null);

	        if (user != null) {
	            if (user.getPassword().equals(request.getPassword())) {
	                // Generate JWT token
	                String token = generateJwtToken(user.getEmail());

	                // Return the JWT token in the response
	                return ResponseEntity.ok(token);
	            } else {
	                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid password");
	            }
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email not found");
	        }
	    }

	    private String generateJwtToken(String email) {
	        byte[] keyBytes = Base64.getDecoder().decode(secretKey);
	        Key key = Keys.hmacShaKeyFor(keyBytes);

	        return Jwts.builder()
	                .setSubject(email)
	                .signWith(key, SignatureAlgorithm.HS256)
	                .compact();
	    }
}

package com.stories.Requests;

import lombok.Data;

@Data
public class CommentRequest {

	public String content ; 
	
	public int authorID ;
	
	public int postID ;
}

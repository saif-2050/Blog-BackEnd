package com.stories.Requests;

import java.util.List;
import java.sql.Timestamp;

import com.stories.Models.Author;
import com.stories.Models.Comment;

import lombok.Data;
@Data
public class postResponse {
	private int id;
    private String title;
    private String content;
    private String postImageUrl;
    private Timestamp timePosted;
    private int nbrSeeing;
    private Author blogger;
    private List<Comment> comment;
    private List<String> tagNames;
    
    public postResponse(int id, String title, String content, String postImageUrl, Timestamp timePosted, int nbrSeeing, Author blogger, List<String> tagNames,List<Comment> comment) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.postImageUrl = postImageUrl;
        this.timePosted = timePosted;
        this.nbrSeeing = nbrSeeing;
        this.blogger = blogger;
        this.tagNames = tagNames;
        this.comment = comment ;
    }
}

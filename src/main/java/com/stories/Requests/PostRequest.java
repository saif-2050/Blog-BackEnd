package com.stories.Requests;

import java.util.List;

import lombok.Data;
@Data
public class PostRequest {

	private String title;
    private String content;
    public String postimageurl;
    private int authorId;
    private List<Integer> tagIds;
}

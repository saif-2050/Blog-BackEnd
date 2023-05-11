package com.stories.Requests;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stories.Models.TagPost;
import com.stories.Models.Tags;

import lombok.Data;

@Data
public class AuthentificationRequest {
    private String email;
    private String password;
}

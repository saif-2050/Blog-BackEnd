package com.stories.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stories.Models.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer>{

}

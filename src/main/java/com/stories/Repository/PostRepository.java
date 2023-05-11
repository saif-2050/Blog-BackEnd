package com.stories.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stories.Models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

}

package com.stories.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stories.Models.Post;
import com.stories.Models.TagPost;
import com.stories.Models.Tags;
@Repository
public interface TagPostRepository extends JpaRepository<TagPost, Integer> {
    List<TagPost> findByPost(Post post);

}

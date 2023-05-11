package com.stories.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stories.Models.Tags;
@Repository
public interface TagRepository extends JpaRepository<Tags, Integer> {

}

package com.gustavosantos.workshop_mongo.repository;

import com.gustavosantos.workshop_mongo.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    Page<Post> findByTitleContainingIgnoreCase(String title, Pageable pageable);
}

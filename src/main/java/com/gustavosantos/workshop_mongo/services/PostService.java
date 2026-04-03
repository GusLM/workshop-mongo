package com.gustavosantos.workshop_mongo.services;

import com.gustavosantos.workshop_mongo.domain.Post;
import com.gustavosantos.workshop_mongo.repository.PostRepository;
import com.gustavosantos.workshop_mongo.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with ID: " + id + " not found"));
    }

    public Page<Post> findByTitle(String title, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.findByTitle(title, pageable);
    }

    public Page<Post> searchPostsByTextAndDateRange(String text, Date minDate, Date maxDate, int page, int size) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        Pageable pageable = PageRequest.of(page, size);
        return repository.searchPostsByTextAndDateRange(text, minDate, maxDate, pageable);
    }
}

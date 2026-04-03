package com.gustavosantos.workshop_mongo.resources;

import com.gustavosantos.workshop_mongo.domain.Post;
import com.gustavosantos.workshop_mongo.dto.PageResponse;
import com.gustavosantos.workshop_mongo.resources.util.URL;
import com.gustavosantos.workshop_mongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post post = service.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @GetMapping(value = "/title")
    public ResponseEntity<PageResponse<Post>> findByTitle(
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size

    ) {
        text = URL.decodeParam(text);
        Page<Post> posts = service.findByTitle(text, page, size);
        return ResponseEntity.ok().body(PageResponse.from(posts));
    }

    @GetMapping(value = "/search")
    public ResponseEntity<PageResponse<Post>> searchPostsByTextAndDateRange(
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam(value = "initialDate", defaultValue = "") String minDate,
            @RequestParam(value = "finalDate", defaultValue = "") String maxDate,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        text = URL.decodeParam(text);
        Date minDateParam = URL.parseDate(minDate, new Date(0L));
        Date maxDateParam = URL.parseDate(maxDate, new Date());
        Page<Post> list = service.searchPostsByTextAndDateRange(text, minDateParam, maxDateParam, page, size);
        return ResponseEntity.ok().body(PageResponse.from(list));
    }
}

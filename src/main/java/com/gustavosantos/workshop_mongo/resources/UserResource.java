package com.gustavosantos.workshop_mongo.resources;

import com.gustavosantos.workshop_mongo.domain.User;
import com.gustavosantos.workshop_mongo.dto.PageResponse;
import com.gustavosantos.workshop_mongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<PageResponse<User>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Page<User> result = service.findAll(page, size);
        return ResponseEntity.ok().body(PageResponse.from(result));
    }
}

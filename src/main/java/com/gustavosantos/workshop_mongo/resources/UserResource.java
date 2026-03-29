package com.gustavosantos.workshop_mongo.resources;

import com.gustavosantos.workshop_mongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> list = new ArrayList<>();
        User user1 = new User("1001", "Maria", "maria@gmail.com");
        User user2 = new User("1002", "Alex", "alex@gmail.com");
        list.addAll(Arrays.asList(user1, user2));
        return ResponseEntity.ok().body(list);
    }
}

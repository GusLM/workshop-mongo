package com.gustavosantos.workshop_mongo.resources;

import com.gustavosantos.workshop_mongo.domain.User;
import com.gustavosantos.workshop_mongo.dto.PageResponse;
import com.gustavosantos.workshop_mongo.dto.UserDTO;
import com.gustavosantos.workshop_mongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<PageResponse<UserDTO>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Page<User> result = service.findAll(page, size);
        Page<UserDTO> userDTOPage = result.map(user -> new UserDTO(user));
        return ResponseEntity.ok().body(PageResponse.from(userDTOPage));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        User obj = service.findById(id);
        return ResponseEntity.ok().body(new UserDTO(obj));
    }
}

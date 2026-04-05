package com.gustavosantos.workshop_mongo.resources;

import com.gustavosantos.workshop_mongo.domain.User;
import com.gustavosantos.workshop_mongo.dto.PageResponse;
import com.gustavosantos.workshop_mongo.dto.UserDTO;
import com.gustavosantos.workshop_mongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<PageResponse<UserDTO>> findAll(
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        if (name != null && !name.isBlank()) {
            Page<User> pageUser = service.findByName(name,page,size);
            Page<UserDTO> pageUserDTO = pageUser.map(user -> new UserDTO(user));
            return ResponseEntity.ok().body(PageResponse.from(pageUserDTO));
        }
        Page<User> result = service.findAll(page, size);
        Page<UserDTO> userDTOPage = result.map(user -> new UserDTO(user));
        return ResponseEntity.ok().body(PageResponse.from(userDTOPage));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        User obj = service.findById(id);
        return ResponseEntity.ok().body(new UserDTO(obj));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO dto) {
        User obj = service.insert(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getId())
                .toUri();
        return ResponseEntity.created(uri).build();

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable String id, @RequestBody UserDTO dto) {
        User obj = service.update(id, dto);
        return ResponseEntity.ok().body(new UserDTO(obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

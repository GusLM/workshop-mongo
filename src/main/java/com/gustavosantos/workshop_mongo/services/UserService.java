package com.gustavosantos.workshop_mongo.services;

import com.gustavosantos.workshop_mongo.domain.User;
import com.gustavosantos.workshop_mongo.dto.UserDTO;
import com.gustavosantos.workshop_mongo.repository.UserRepository;
import com.gustavosantos.workshop_mongo.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public Page<User> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.findAll(pageable);
    }

    public User findById(String id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    public User insert(UserDTO dto) {
        User user = new User();
        updateUser(user, dto);
        return repository.save(user);
    }

    public User update(String id, UserDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
        User obj = repository.getUserById(id);
        updateUser(obj, dto);
        return repository.save(obj);
    }

    public void delete(String id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
        repository.deleteById(id);

    }

    public void updateUser(User entity, UserDTO dto) {
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
    }
}

package com.gustavosantos.workshop_mongo.repository;

import com.gustavosantos.workshop_mongo.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    @Query("{ name: { $regex: ?0, $options: 'i' } }")
    Page<User> findByName(String name, Pageable pageable);
}

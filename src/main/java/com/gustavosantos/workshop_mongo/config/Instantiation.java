package com.gustavosantos.workshop_mongo.config;

import com.gustavosantos.workshop_mongo.domain.Post;
import com.gustavosantos.workshop_mongo.domain.User;
import com.gustavosantos.workshop_mongo.dto.AuthorDTO;
import com.gustavosantos.workshop_mongo.dto.CommentDTO;
import com.gustavosantos.workshop_mongo.repository.PostRepository;
import com.gustavosantos.workshop_mongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, sdf.parse("2024-01-12"), "Good morning", "This is the first post", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("2025-05-13"), "Good afternoon", "This is the second post", new AuthorDTO(alex));
        Post post3 = new Post(null, sdf.parse("2026-03-14"), "Good night", "This is the third post",new AuthorDTO(bob));

        CommentDTO comment1 = new CommentDTO("Github", sdf.parse("2024-01-16"), new AuthorDTO(maria));
        CommentDTO comment2 = new CommentDTO("Java", sdf.parse("2025-05-17"), new AuthorDTO(alex));
        CommentDTO comment3 = new CommentDTO("IntelliJ IDE", sdf.parse("2026-03-18"), new AuthorDTO(bob));
        post1.addComment(comment1);
        post1.addComment(comment2);
        post2.addComment(comment3);

        postRepository.saveAll(Arrays.asList(post1, post2, post3));

        maria.addPost(post1);
        alex.addPost(post2);
        bob.addPost(post3);

        userRepository.saveAll(Arrays.asList(maria, alex, bob));
    }
}

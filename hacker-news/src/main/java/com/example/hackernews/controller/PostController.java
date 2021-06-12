package com.example.hackernews.controller;

import com.example.hackernews.model.Content;
import com.example.hackernews.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {
    private PostRepository postRepository;

    @Autowired
    public PostController(final PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    @GetMapping("/content")
    public List<Content> getAllContents() {
       return postRepository.getAll();
    }
}

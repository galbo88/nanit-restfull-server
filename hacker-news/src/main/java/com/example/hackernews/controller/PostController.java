package com.example.hackernews.controller;

import com.example.hackernews.model.Content;
import com.example.hackernews.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/content")
@RestController
public class PostController {
    private PostRepository postRepository;

    @Autowired
    public PostController(final PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    @RequestMapping(value = "/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Content> getAllContents() {
        return postRepository.getAll();
    }

    @RequestMapping(value = "/",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            params = {"contentId"})
    public Content getById(@RequestParam String contentId) {
        return postRepository.getById(contentId);
    }

    @RequestMapping(value = "/",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.TEXT_PLAIN_VALUE)
    public String postContent(@RequestBody String content) {
        return postRepository.postContent(content);
    }

}

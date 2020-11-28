package com.example.demo.posts;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PostClient {
    private RestTemplate postsRestTemplate;

    public PostClient(RestTemplate postsRestTemplate) {
        this.postsRestTemplate = postsRestTemplate;
    }

    public Post findPostById(Long id) {
        return postsRestTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/" + id, Post.class);
    }
}

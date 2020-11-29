package com.example.demo.posts;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UsersClient {
    private RestTemplate postsRestTemplate;

    public UsersClient(RestTemplate postsRestTemplate) {
        this.postsRestTemplate = postsRestTemplate;
    }

    public User getUserById(Long userId) {
        return postsRestTemplate.getForObject("https://jsonplaceholder.typicode.com/users/" + userId, User.class);
    }
}

package com.example.demo.posts;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostClient {
    private RestTemplate postsRestTemplate;

    public PostClient(RestTemplate postsRestTemplate) {
        this.postsRestTemplate = postsRestTemplate;
    }

    public Post findPostById(Long id) {
        return postsRestTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/" + id, Post.class);
    }

    public List<Comment> findCommentsForPost(Long postId) {
        return postsRestTemplate.exchange(
                "https://jsonplaceholder.typicode.com/posts/" + postId + "/comments",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Comment>>() {}
        ).getBody();
    }

    public List<Comment> findCommentsForPost(Long postId, String commentAuthor) {
        return postsRestTemplate.exchange(
                "https://jsonplaceholder.typicode.com/posts/" + postId + "/comments",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Comment>>() {}
            ).getBody()
                .stream()
                .filter(comment -> commentAuthor == null || comment.getEmail().equals(commentAuthor))
                .collect(Collectors.toList());
    }
}

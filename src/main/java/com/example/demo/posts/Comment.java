package com.example.demo.posts;

public class Comment {
    private Long id;
    private String email;
    private String body;

    public Comment(Long id, String email, String body) {
        this.id = id;
        this.email = email;
        this.body = body;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getBody() {
        return body;
    }
}

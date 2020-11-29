package com.example.demo.posts;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@Service
public class UsersClient {
    private RestTemplate usersRestTemplate;

    public UsersClient(RestTemplate usersRestTemplate) {
        this.usersRestTemplate = usersRestTemplate;
    }

    public User getUserById(Long userId) {
        try {
            ResponseEntity<User> response = usersRestTemplate.exchange(
                    "https://jsonplaceholder.typicode.com/users/" + userId,
                    HttpMethod.GET,
                    null,
                    User.class
            );
            return response.getBody();
        } catch (HttpStatusCodeException exception) {
            throw new UserNotFoundException(userId);
        }
    }
}

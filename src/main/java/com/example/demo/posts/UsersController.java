package com.example.demo.posts;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("users")
public class UsersController {

    private UsersClient usersClient;

    public UsersController(UsersClient usersClient) {
        this.usersClient = usersClient;
    }

    @GetMapping("/{id}")
    public ModelAndView modelAndView(@PathVariable("id") Long userId) {
        ModelAndView modelAndView = new ModelAndView("singleUser");
        modelAndView.addObject("user", usersClient.getUserById(userId));
        return modelAndView;
    }
}

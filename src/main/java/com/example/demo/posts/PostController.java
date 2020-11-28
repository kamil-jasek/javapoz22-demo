package com.example.demo.posts;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/posts")
public class PostController {

    private PostClient postClient;

    public PostController(PostClient postClient) {
        this.postClient = postClient;
    }

    @GetMapping("/{id}")
    public ModelAndView singlePost(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("singelPost");
        modelAndView.addObject("singlePost", postClient.findPostById(id));
        return modelAndView;
    }
}

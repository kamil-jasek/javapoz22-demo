package com.example.demo.posts;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/posts")
public class PostController {

    private PostClient postClient;

    public PostController(PostClient postClient) {
        this.postClient = postClient;
    }

    @GetMapping(value = "/{id}")
    public ModelAndView singlePost(@PathVariable("id") Long id) {
        System.out.println("all posts");
        ModelAndView modelAndView = new ModelAndView("singelPost");
        modelAndView.addObject("singlePost", postClient.findPostById(id));
        modelAndView.addObject("comments", postClient.findCommentsForPost(id));
        return modelAndView;
    }

    @GetMapping(value = "/{id}", params = "commentAuthor")
    public ModelAndView singlePost(@PathVariable("id") Long id, @RequestParam(value = "commentAuthor") String commentAuthor) {
        System.out.println("filtered posts");
        ModelAndView modelAndView = new ModelAndView("singelPost");
        modelAndView.addObject("singlePost", postClient.findPostById(id));
        modelAndView.addObject("comments", postClient.findCommentsForPost(id, commentAuthor));
        return modelAndView;
    }



}

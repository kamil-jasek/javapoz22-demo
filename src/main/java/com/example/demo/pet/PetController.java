package com.example.demo.pet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pet")
public class PetController {
    private PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping
    public ModelAndView allPets() {
        ModelAndView modelAndView = new ModelAndView("pet/allPets");
        modelAndView.addObject("pets", petService.findAll());
        return modelAndView;
    }
}
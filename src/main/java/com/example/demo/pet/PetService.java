package com.example.demo.pet;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {
    private PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public List<Pet> findAll() {
        return petRepository.findAll();
    }

    public List<Pet> findAllBetweenAge(Integer ageFrom, Integer ageTo) {
        return petRepository.findAllBetweenAge(ageFrom, ageTo);
    }

    public Pet findById(Long id) {
        return petRepository.findById(id)
                .orElse(null);
    }

    public Pet savePet(Pet pet) {
        return petRepository.save(pet);
    }
}

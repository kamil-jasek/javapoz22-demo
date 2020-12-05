package com.example.demo.pet;

import java.util.List;
import java.util.Optional;

public interface PetRepository {
    Optional<Pet> findById(Long id);
    List<Pet> findAll();
    List<Pet> findAllBetweenAge(Integer ageFrom, Integer ageTo);
}

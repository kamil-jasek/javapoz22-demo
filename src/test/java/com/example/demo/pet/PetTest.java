package com.example.demo.pet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
final class PetTest {

    @Autowired
    private JpaPetRepository repository;

    @Test
    void shouldSavePet() {
        // given
        var pet = new Pet("rambo", "terrier", 7, "Kamil", "/rambo.jpg");

        // when
        repository.save(pet);

        // then
        final var result = repository.findById(pet.getId());
        assertTrue(result.isPresent());
        assertEquals(pet, result.get());
    }
}

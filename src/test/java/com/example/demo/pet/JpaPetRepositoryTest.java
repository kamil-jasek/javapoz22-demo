package com.example.demo.pet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JpaPetRepositoryTest {

    @Autowired
    private JpaPetRepository repository;

    @Autowired
    private EntityManager em;

    @Test
    @Transactional
    void shouldASavePet() {
        // given
        var pet = new Pet("rambo", "terrier", 7, "Kamil", "/rambo.jpg");

        // when
        repository.save(pet);
        em.clear();

        // then
        final var result = repository.findById(pet.getId());
        assertTrue(result.isPresent());
        assertEquals(pet, result.get());
    }

    @Test
    @Transactional
    void shouldFindPetsBetweenAge() {
        // given
        var pet1 = new Pet("rambo", "terrier", 7, "Kamil", "/rambo.jpg");
        var pet2 = new Pet("rocky", "terrier", 3, "Kamil", "/rocky.jpg");
        var pet3 = new Pet("rudolf", "terrier", 5, "Kamil", "/rudolf.jpg");
        repository.saveAll(List.of(pet1, pet2, pet3));

        // when
        var result = repository.findAllBetweenAge(4, 8);

        // then
        assertFalse(result.isEmpty());
        assertEquals(2, result.size());
        assertTrue(result.containsAll(List.of(pet1, pet3)));
    }
}

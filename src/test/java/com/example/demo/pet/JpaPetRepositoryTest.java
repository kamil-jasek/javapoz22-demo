package com.example.demo.pet;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigInteger;
import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.hibernate.Hibernate;
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

    @Test
    @Transactional
    void shouldCountPetsWithMinimalAgeByOwner() {
        // given
        var pet1 = new Pet("rambo", "terrier", 7, "Kamil", "/rambo.jpg");
        var pet2 = new Pet("rocky", "terrier", 3, "Kamil", "/rocky.jpg");
        var pet3 = new Pet("rudolf", "terrier", 5, "Janek", "/rudolf.jpg");
        var pet4 = new Pet("rudolf", "terrier", 2, "Janek", "/rudolf.jpg");
        var pet5 = new Pet("rudolf", "terrier", 2, "Robert", "/rudolf.jpg");
        repository.saveAll(List.of(pet1, pet2, pet3, pet4, pet5));

        // when
        var result = repository.countByOwnerWithMinimalAge(3);

        // then
        assertFalse(result.isEmpty());
        assertEquals(2, result.size());
        assertArrayEquals(new Object[] { BigInteger.valueOf(1), "Janek" }, result.get(0));
        assertArrayEquals(new Object[] { BigInteger.valueOf(2), "Kamil" }, result.get(1));
    }

    @Test
    @Transactional
    void shouldCountPetsWithMaximumAgeByOwner() {
        // given
        var pet1 = new Pet("rambo", "terrier", 7, "Kamil", "/rambo.jpg");
        var pet2 = new Pet("rocky", "terrier", 3, "Kamil", "/rocky.jpg");
        var pet3 = new Pet("rudolf", "terrier", 5, "Janek", "/rudolf.jpg");
        var pet4 = new Pet("rudolf", "terrier", 2, "Janek", "/rudolf.jpg");
        var pet5 = new Pet("rudolf", "terrier", 2, "Robert", "/rudolf.jpg");
        repository.saveAll(List.of(pet1, pet2, pet3, pet4, pet5));

        // when
        var result = repository.countByOwnerWithMaximumAge(5);

        // then
        assertFalse(result.isEmpty());
        assertEquals(3, result.size());

        var row1 = result.get(0);
        assertEquals(2, row1.getCount());
        assertEquals("Janek", row1.getOwner());

        var row2 = result.get(1);
        assertEquals(1, row2.getCount());
        assertEquals("Kamil", row2.getOwner());

        var row3 = result.get(2);
        assertEquals(1, row3.getCount());
        assertEquals("Robert", row3.getOwner());
    }

    @Test
    @Transactional
    void shouldChangePetName() {
        // given
        var pet = new Pet("rambo", "terrier", 7, "Kamil", "/rambo.jpg");
        repository.save(pet);
        em.clear();

        // when
        final var updated = repository.updatePetName(pet.getId(), "rocky");

        // then
        assertEquals(1, updated);
        final var updatedPet = Hibernate.unproxy(repository.getOne(pet.getId()), Pet.class);
        assertEquals("rocky", updatedPet.getName());
    }
}

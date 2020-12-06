package com.example.demo.pet;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JpaPetRepository extends JpaRepository<Pet, Long> {

    @Query("from Pet p where p.age between :ageFrom and :ageTo")
    List<Pet> findAllBetweenAge(Integer ageFrom, Integer ageTo);
}

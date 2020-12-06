package com.example.demo.pet;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JpaPetRepository extends JpaRepository<Pet, Long> {

    @Query("from Pet p where p.age between :ageFrom and :ageTo")
    List<Pet> findAllBetweenAge(Integer ageFrom, Integer ageTo);

    @Query(value = "select count(id), owner from pets where age >= :age group by owner order by owner",
           nativeQuery = true)
    List<Object[]> countByOwnerWithMinimalAge(int age);

    @Query(value = "select count(id) as count, owner from pets where age <= :age group by owner order by owner",
           nativeQuery = true)
    List<CountByOwner> countByOwnerWithMaximumAge(int age);

    interface CountByOwner {
        int getCount();
        String getOwner();
    }
}

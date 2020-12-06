package com.example.demo.pet;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPetRepository extends JpaRepository<Pet, Long> {

}

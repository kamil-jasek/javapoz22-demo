package com.example.demo.pet;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pets")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String breed;
    private Integer age;
    private String owner;
    private String imgUrl;

    // only for JPA
    protected Pet() {}

    public Pet(String name, String breed, Integer age, String owner, String imgUrl) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.owner = owner;
        this.imgUrl = imgUrl;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public Integer getAge() {
        return age;
    }

    public String getOwner() {
        return owner;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pet pet = (Pet) o;
        return id.equals(pet.id) && name.equals(pet.name) && breed.equals(pet.breed) && age.equals(pet.age) && owner
            .equals(pet.owner) && imgUrl.equals(pet.imgUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, breed, age, owner, imgUrl);
    }
}

package com.example.demo.pet;

public class Pet {
    private Long id;
    private String name;
    private String breed;
    private Integer age;
    private String owner;
    private String imgUrl;

    public Pet(Long id, String name, String breed, Integer age, String owner, String imgUrl) {
        this.id = id;
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
}

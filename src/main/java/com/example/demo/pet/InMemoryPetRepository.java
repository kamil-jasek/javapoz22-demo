package com.example.demo.pet;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class InMemoryPetRepository implements PetRepository {
    private List<Pet> pets;
    private Long nextPetId;

    public InMemoryPetRepository() {
        this.pets = new ArrayList<>();
        this.nextPetId = 1L;
    }

    @Override
    public Optional<Pet> findById(Long id) {
        return pets.stream()
                .filter(pet -> pet.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Pet> findAll() {
        return new ArrayList<>(pets);
    }

    @Override
    public List<Pet> findAllBetweenAge(Integer ageFrom, Integer ageTo) {
        return pets.stream()
                .filter(pet -> pet.getAge() >= ageFrom && pet.getAge() <= ageTo)
                .collect(Collectors.toList());
    }

    @Override
    public Pet save(Pet pet) {
        pet.setId(nextPetId);
        nextPetId++;
        this.pets.add(pet);
        return pet;
    }

    @PostConstruct
    public void init() {
        save(new Pet("Reksio", "Jack Russell terrier", 3, "Jan Kowalski", "https://bi.im-g.pl/im/70/59/14/z21336688IBG,REKSIO---SERIAL-ANIMOWANY-DLA-DZIECI.jpg"));
        save(new Pet("Psislaw", "Owczarek", 7, "Adam Nowak", "https://i.wpimg.pl/1920x0/portal-abczdrowie.wpcdn.pl/2018/11/21/owczarek-niemiecki_5eba.jpg"));
        save(new Pet("Marshal", "Dalmatyńczyk", 5, "Anna Wisniewska", "https://vignette.wikia.nocookie.net/psi-patrol/images/9/94/Pobrane_%2836%29.jpg/revision/latest/top-crop/width/360/height/450?cb=20170504114138&path-prefix=pl"));
    }
}

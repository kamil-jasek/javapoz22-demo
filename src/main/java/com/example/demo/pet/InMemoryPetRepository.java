package com.example.demo.pet;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryPetRepository implements PetRepository {
    private List<Pet> pets;

    public InMemoryPetRepository() {
        this.pets = new ArrayList<>();
    }

    @Override
    public List<Pet> findAll() {
        return new ArrayList<>(pets);
    }

    @PostConstruct
    public void init() {
        this.pets.add(new Pet(1L, "Reksio", "abc", 3, "Jan Kowalski", "https://bi.im-g.pl/im/70/59/14/z21336688IBG,REKSIO---SERIAL-ANIMOWANY-DLA-DZIECI.jpg"));
        this.pets.add(new Pet(2L, "Psislaw", "Owczarek", 2, "Adam Nowak", "https://i.wpimg.pl/1920x0/portal-abczdrowie.wpcdn.pl/2018/11/21/owczarek-niemiecki_5eba.jpg"));
        this.pets.add(new Pet(3L, "Marshal", "Dalmatyńczyk", 3, "Anna Wisniewska", "https://vignette.wikia.nocookie.net/psi-patrol/images/9/94/Pobrane_%2836%29.jpg/revision/latest/top-crop/width/360/height/450?cb=20170504114138&path-prefix=pl"));
    }
}

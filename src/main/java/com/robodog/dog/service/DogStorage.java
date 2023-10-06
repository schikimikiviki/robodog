package com.robodog.dog.service;

import com.robodog.dog.model.Breed;
import com.robodog.dog.model.Dog;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DogStorage {

    private List<Dog> listOfDogs = new ArrayList<>();

    public void addDog(Dog dog) {
        listOfDogs.add(dog);
    }

    public void addRandomDog() {
        DogCreator dogCreator = new DogCreator();
        listOfDogs.add(dogCreator.createRandomDog());
    }

    public List<Dog> getAllDogs() {
        return listOfDogs;
    }

    public void updateAgeAndBreed(String name, int newAge, Breed breed) {
        Optional<Dog> dogWithGivenName = listOfDogs.stream()
                .filter(dog -> dog.getName().equals(name))
                .findFirst();

        if (dogWithGivenName.isPresent()) {
            Dog dog = dogWithGivenName.get();
            dog.setAge(newAge);
            dog.setBreed(breed);
            System.out.println("Dog with given name updated!");
        } else {
            System.out.println("Dog with given name not found.");
        }
    }
}

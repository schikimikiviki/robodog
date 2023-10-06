package com.robodog.dog.service;

import com.robodog.dog.model.Breed;
import com.robodog.dog.model.Dog;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class DogStorage {

    private List<Dog> listOfDogs = new ArrayList<>();
    private long lastAssignedId = 0;

    public void addDog(Dog dog) {
        dog.setId(++lastAssignedId);
        listOfDogs.add(dog);
    }

    public void addRandomDog() {
        DogCreator dogCreator = new DogCreator();
        listOfDogs.add(dogCreator.createRandomDog());
    }

    public List<Dog> getAllDogs() {
        return listOfDogs;
    }

    public Dog updateAgeAndBreed(String name, int newAge, Breed breed) {
        Optional<Dog> dogWithGivenName = listOfDogs.stream()
                .filter(dog -> dog.getName().equals(name))
                .findFirst();

        if (dogWithGivenName.isPresent()) {
            Dog dog = dogWithGivenName.get();
            dog.setAge(newAge);
            dog.setBreed(breed);
            System.out.println("Dog with given name updated!");
            return dog;
        } else {
            System.out.println("Dog with given name not found.");
            return null;
        }
    }

    public Dog findAndDeleteDog(int id) {
        Optional<Dog> dogToDelete = listOfDogs.stream()
                .filter(dog -> dog.getId() == id)
                .findFirst();

        if (dogToDelete.isPresent()) {
            Dog deletedDog = dogToDelete.get();
            listOfDogs.remove(deletedDog);
            return deletedDog;
        } else {
            return null;
        }
    }

}

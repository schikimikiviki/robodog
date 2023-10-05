package com.robodog.dog.service;

import com.robodog.dog.model.Breed;
import com.robodog.dog.model.Dog;

import java.util.Random;

public class DogCreator {

    public Dog createRandomDog() {


        Random random = new Random();
        int randomAge = random.nextInt(50);

        String[] namesList = new String[]{"Annie", "Sam", "Bella", "Nino", "Lilo", "Twix", "Richy"};
        String randomName = namesList[(random.nextInt(namesList.length))];

        Breed[] allBreeds = new Breed[]{Breed.BEAGLE, Breed.HUSKY, Breed.LABRADOR, Breed.ROTTWEILER, Breed.POODLE, Breed.GOLDEN_RETRIEVER, Breed.BOXER};
        Breed randomBreed = allBreeds[(random.nextInt(namesList.length))];

        return new Dog(randomName, randomAge, randomBreed);

    }
}

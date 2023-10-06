package com.robodog.dog.controller;


import com.robodog.dog.model.Dog;
import com.robodog.dog.service.DogStorage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("dogs")
public class DogController {

    private final DogStorage dogStorage;

    public DogController(DogStorage dogStorage) {
        this.dogStorage = dogStorage;
    }

    @GetMapping
    List<Dog> findAll() {
        return dogStorage.getAllDogs();
    }

    @GetMapping("/random")
    List<Dog> getRandomDog() {
        dogStorage.addRandomDog();
        return dogStorage.getAllDogs();
    }

    @PostMapping
    List<Dog> addDog(@RequestBody Dog dog) {
        dogStorage.addDog(dog);
        return dogStorage.getAllDogs();
    }

    @PutMapping("/{name}")
    Dog changeDog(@PathVariable String name, @RequestBody Dog newDog) {
        return dogStorage.updateAgeAndBreed(name, newDog.getAge(), newDog.getBreed());

    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteDog(@PathVariable int id) {
        Dog deletedDog = dogStorage.findAndDeleteDog(id);

        if (deletedDog != null) {
            String message = "Dog deleted: " + deletedDog.toString();
            return ResponseEntity.ok(message);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}

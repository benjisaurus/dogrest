package com.udacity.dogrest.service;

import com.udacity.dogrest.entity.Dog;
import com.udacity.dogrest.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DogService {

    @Autowired
    DogRepository dogRepository;

    public List<Dog> retrieveDogs() { return (List<Dog>) dogRepository.findAll(); }

    public String retrieveBreedById(Long id) {
        String retStr = "No dog with that id";
        Optional<Dog> d = dogRepository.findById(id);
        if(d.isPresent()){
            retStr = d.get().getBreed();
        }
        return retStr;
    }

    public List<String> retrieveDogBreeds() {
        List<String> breeds = new ArrayList<String>();
        List<Dog> dogs = (List<Dog>) dogRepository.findAll();
        for (Dog dog : dogs) {
            breeds.add(dog.getBreed());
        }
        return breeds;
    }

    public List<String> retrieveDogNames() {
        List<String> names = new ArrayList<String>();
        List<Dog> dogs = (List<Dog>) dogRepository.findAll();
        for (Dog dog : dogs) {
            names.add(dog.getName());
        }
        return names;
    }
}

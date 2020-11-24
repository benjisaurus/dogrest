package com.udacity.dogrest.repository;

import com.udacity.dogrest.entity.Dog;
import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog, Long> {
}

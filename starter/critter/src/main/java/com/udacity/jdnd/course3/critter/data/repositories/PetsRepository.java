package com.udacity.jdnd.course3.critter.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.udacity.jdnd.course3.critter.data.entities.Pet;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetsRepository extends JpaRepository<Pet, Long> {

    List<Pet> getAllByCustomerId(Long customerId);

}

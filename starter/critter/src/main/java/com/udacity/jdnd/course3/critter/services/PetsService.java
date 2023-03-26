package com.udacity.jdnd.course3.critter.services;


import com.udacity.jdnd.course3.critter.data.entities.Customer;
import com.udacity.jdnd.course3.critter.data.entities.Pet;
import com.udacity.jdnd.course3.critter.data.repositories.CustomersRepository;
import com.udacity.jdnd.course3.critter.data.repositories.PetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetsService {

    @Autowired
    private PetsRepository petsRepository;

    @Autowired
    private CustomersRepository customersRepository;

    public List<Pet> getAllPets(){
       return petsRepository.findAll();
    }

    public List<Pet> getPetsByCustomerId(Long customerId){
        return petsRepository.getAllByCustomerId(customerId);
    }

    public Pet getPetById(Long petId){
        return petsRepository.getOne(petId);
    }

    public Pet savePet(Pet pet, long ownerId) {
        Customer customer = customersRepository.getOne(ownerId);
        pet.setCustomer(customer);
        pet = petsRepository.save(pet);
        customer.insertPet(pet);
        customersRepository.save(customer);
        return pet;
    }

}

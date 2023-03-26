package com.udacity.jdnd.course3.critter.data.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
public class Customer implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String phoneNumber;
    private String notes;
    @OneToMany
    private List<Pet> pets;
    public void insertPet(Pet pet) {
        pets.add(pet);
    }
}

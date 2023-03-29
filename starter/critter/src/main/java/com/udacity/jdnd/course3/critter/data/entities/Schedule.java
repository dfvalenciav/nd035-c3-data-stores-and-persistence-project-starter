package com.udacity.jdnd.course3.critter.data.entities;


import com.udacity.jdnd.course3.critter.controller.user.EmployeeSkill;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table
@Data
@NoArgsConstructor
public class Schedule implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne (targetEntity = Employee.class)
    private List<Employee> employees;

    @ManyToOne (targetEntity = Pet.class)
    private List<Pet> pets;

    private LocalDate date;

    @ElementCollection
    private Set<EmployeeSkill> activities;
}

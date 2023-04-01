package com.udacity.jdnd.course3.critter.data.repositories;

import com.udacity.jdnd.course3.critter.data.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepository extends JpaRepository<Customer, Long> {
}

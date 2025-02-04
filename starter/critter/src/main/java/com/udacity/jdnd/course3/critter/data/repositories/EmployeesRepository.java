package com.udacity.jdnd.course3.critter.data.repositories;

import com.udacity.jdnd.course3.critter.data.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.util.List;

@Repository
public interface EmployeesRepository extends JpaRepository <Employee , Long> {

    List<Employee> getAllByDaysAvailableContains(DayOfWeek dayOfWeek);
}

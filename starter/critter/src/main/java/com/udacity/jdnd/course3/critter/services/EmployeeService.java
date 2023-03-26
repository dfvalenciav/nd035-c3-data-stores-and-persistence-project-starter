package com.udacity.jdnd.course3.critter.services;

import com.udacity.jdnd.course3.critter.controller.user.EmployeeSkill;
import com.udacity.jdnd.course3.critter.data.entities.Employee;
import com.udacity.jdnd.course3.critter.data.repositories.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeesRepository  employeesRepository;

    public Employee getEmployeeById (Long employId){
        return employeesRepository.getOne(employId);
    }

    public Employee saveEmployee (Employee employee){
        return employeesRepository.save(employee);
    }

    public List<Employee> getEmployeesForService (LocalDate localDate, Set<EmployeeSkill> employeeSkillSet){
        List<Employee> employees = employeesRepository
                .getAllByDaysAvailableContains(localDate.getDayOfWeek()).stream()
                .filter(employee -> employee.getSkills().containsAll(employeeSkillSet))
                .collect(Collectors.toList());
        return employees;
    }

    public void setEmployeeAvailability (Set<DayOfWeek> dayOfWeeks , Long employeeId){
        Employee employee = employeesRepository.getOne(employeeId);
        employee.setDaysAvailable(dayOfWeeks);
        employeesRepository.save(employee);
    }

}

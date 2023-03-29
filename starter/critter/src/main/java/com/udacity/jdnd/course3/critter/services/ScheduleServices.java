package com.udacity.jdnd.course3.critter.services;

import com.udacity.jdnd.course3.critter.data.entities.Customer;
import com.udacity.jdnd.course3.critter.data.entities.Employee;
import com.udacity.jdnd.course3.critter.data.entities.Pet;
import com.udacity.jdnd.course3.critter.data.entities.Schedule;
import com.udacity.jdnd.course3.critter.data.repositories.CustomersRepository;
import com.udacity.jdnd.course3.critter.data.repositories.EmployeesRepository;
import com.udacity.jdnd.course3.critter.data.repositories.PetsRepository;
import com.udacity.jdnd.course3.critter.data.repositories.SchedulesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServices {
    @Autowired
    private CustomersRepository customersRepository;
    @Autowired
    private EmployeesRepository employeesRepository;
    @Autowired
    private PetsRepository petsRepository;
    @Autowired
    private SchedulesRepository schedulesRepository;

    public List<Schedule> getAllSchedules (){
        return schedulesRepository.findAll();
    }

    public List<Schedule> getAllSchedulesForPet(Long petId){
        Pet pet = petsRepository.getOne(petId);
        return schedulesRepository.getAllByPetsContains(pet);
    }

    public List<Schedule> getAllSchedulesForCustomer(Long customerId){
        Customer customer = customersRepository.getOne(customerId);
        return schedulesRepository.getAllByPetsIn(customer.getPets());
    }

    public List<Schedule> getAllSchedulesForEmployee(Long employeeId){
        Employee employee = employeesRepository.getOne(employeeId);
        return schedulesRepository.getAllByEmployeesContains(employee);
    }

    public Schedule saveSchedule(Schedule schedule, List<Long> employeeIds, List<Long> petIds) {
        List<Employee> employees = employeesRepository.findAllById(employeeIds);
        List<Pet> pets = petsRepository.findAllById(petIds);
        schedule.setEmployees(employees);
        schedule.setPets(pets);
        return schedulesRepository.save(schedule);
    }
}

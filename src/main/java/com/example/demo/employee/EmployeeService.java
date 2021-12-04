package com.example.demo.employee;

import com.example.demo.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }


    public Employee saveEmployee(Employee employee) {
        return  employeeRepository.saveAndFlush(employee);
    }

    public void deleteEmployee(Employee employee,Long id) {
        employeeRepository.deleteById(id);
    }

    public Employee editEmployee(Employee employee,Long id) {
        return employeeRepository.saveAndFlush(employee);
    }

    public Employee findEmployeeByID(Long id) {
        return  employeeRepository.getById(id);
    }


}

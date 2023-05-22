package com.example.redis.controller;

import com.example.redis.entity.Employee;
import com.example.redis.repositoty.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Controller
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee){
        employeeRepository.saveEmployee(employee);
        return employee;
    }
    @PostMapping("/find{id}")
    public Employee findById(@RequestParam("id") Integer id){
        return employeeRepository.findById(id);
    }
    @PostMapping("/findAll")
    public List<Employee> findAll(){
        return employeeRepository.fillAll();
    }
    @PostMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeRepository.update(employee);
        return employee;
    }

    @PostMapping("/find{id}")
    public String delete(@RequestParam("id") Integer id){
        employeeRepository.delete(id);
        return "Success";
    }
}

package com.dummy.service.dummyService.controller;

import com.dummy.service.dummyService.model.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient("employee-service/employee")
public interface EmployeeConsumer {

    @PostMapping("/add-employee")
    ResponseEntity<Employee> addEmployee(@RequestBody Employee employee);


    //get all employees
    @GetMapping("/get-employees")
    List<Employee> getAllEmployees();


    //edit employee details
    @PutMapping("/edit-employee")
    ResponseEntity<Employee> editEmployee(@RequestBody Map<String, Object> requestBody);


    //delete employee by id
    @DeleteMapping("/delete-employee/{id}")
    String deleteEmployeeById(@PathVariable("id") int id);

}
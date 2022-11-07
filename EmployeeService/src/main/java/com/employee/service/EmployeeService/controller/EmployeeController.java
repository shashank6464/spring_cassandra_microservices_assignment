package com.employee.service.EmployeeService.controller;


import com.employee.service.EmployeeService.model.Employee;
import com.employee.service.EmployeeService.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;


// when backend and database are on different ports->(enable this)
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService service;

    public EmployeeController(EmployeeService service){
        this.service = service;
    }


    //add new employee
    @PostMapping("/add-employee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        return service.addEmployee(employee);
    }


    //get all employees
    @GetMapping("/get-employees")
    public List<Employee> getAllEmployees(){
        return service.getAllEmployees();
    }


    //edit employee details
    @PutMapping("/edit-employee")
    public ResponseEntity<Employee> editEmployee(@RequestBody Map<String, Object> requestBody){
        return service.editEmployee(requestBody);
    }


    //delete Employee by Id
    @DeleteMapping("/delete-employee/{id}")
    public String deleteEmployeeById(@PathVariable("id") int id){
        return service.deleteEmployee(id);
    }

}

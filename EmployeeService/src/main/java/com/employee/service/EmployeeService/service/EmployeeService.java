package com.employee.service.EmployeeService.service;

import com.employee.service.EmployeeService.model.Employee;
import com.employee.service.EmployeeService.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repository;


    //add employee
    public ResponseEntity<Employee> addEmployee(Employee employee){
        try{
//            Employee tempEmployee = repository.save(new Employee(UUID.randomUUID(),
//                    employee.getName(),
//                    employee.getEmail(),
//                    employee.getState())
//            );
            Employee tempEmployee = repository.save(employee);
            return new ResponseEntity<>(tempEmployee, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //get all employee
    public List<Employee> getAllEmployees(){
        return repository.findAll();
    }


    //edit employee details
    public ResponseEntity<Employee> editEmployee(Map<String, Object> requestBody){

        Optional<Employee> tempEmployee = repository.findById(Integer.parseInt(requestBody.get("id").toString()));

        if(tempEmployee.isPresent()){
            for (Map.Entry<String, Object> entry : requestBody.entrySet()) {
                if(entry.getKey()=="name"){
                    tempEmployee.get().setName(entry.getValue().toString());
                }
                else if(entry.getKey()=="state"){
                    tempEmployee.get().setState(entry.getValue().toString());
                }
            }
            repository.save(tempEmployee.get());
            return new ResponseEntity<>(tempEmployee.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //delete employee by id
    public String deleteEmployee(int id){
        if(repository.existsById(id)){
            repository.deleteById(id);
            return "Successfully Deleted Employee by Id :"+id;
        }
        return "Employee Not Found ";
    }
}

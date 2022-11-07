package com.employee.service.EmployeeService.repository;

import com.employee.service.EmployeeService.model.Employee;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface EmployeeRepository extends CassandraRepository<Employee, Integer> {

    @AllowFiltering
    List<Employee> findByName(String name);

}

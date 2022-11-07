package com.employee.service.EmployeeService.model;


import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;


@Table(value = "employee_assignment")
public class Employee {

    @PrimaryKey
    private int id;

    private String name;
    private String email;
    private String state;
    private String password;

    public Employee(int id, String name, String email, String state, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.state = state;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", state='" + state + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}

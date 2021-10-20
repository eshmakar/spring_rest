package ru.eshmakar.spring.rest.dao;

import ru.eshmakar.spring.rest.entity.Employee;

import java.util.List;


public interface EmployeeDAO {
    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployee(int id);

    void deleteEmployee(int id);
}

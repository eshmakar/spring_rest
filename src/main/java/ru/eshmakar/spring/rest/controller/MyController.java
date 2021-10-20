package ru.eshmakar.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.eshmakar.spring.rest.entity.Employee;
import ru.eshmakar.spring.rest.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")//получаем список всех работников в формате json
    public List<Employee> showAllEmployee(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")//получаем одного работника в формате json
    public Employee getEmployee(@PathVariable int id){ //@PathVariable - используется чтобы читать данные из url
        return employeeService.getEmployee(id);
    }

}

package ru.eshmakar.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.eshmakar.spring.rest.entity.Employee;
import ru.eshmakar.spring.rest.exception_handling.EmployeeIncorrectData;
import ru.eshmakar.spring.rest.exception_handling.NoSuchEmployeeException;
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
        Employee employee = employeeService.getEmployee(id);

        if (employee==null)//если такого работника нет, выбрасываем наш созданный exception в формате json
            throw new NoSuchEmployeeException("Incorrect employee with id = " + id);
        return employee;
    }

    @PostMapping("/employees")//добавляем работника методом POST
    public Employee addEmployee(@RequestBody Employee employee){//заполненяем данные работника с помощью Postman в формате json
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")//эта аннотация используется для изменения данных
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }


    @DeleteMapping("/employees/{id}")//используем для удаления работника
    public String deleteEmployee(@PathVariable int id){//получаем id с юзера
        Employee employee = employeeService.getEmployee(id);
        if (employee==null)//если такого работника нет в базе
            throw new NoSuchEmployeeException("There is not employee with id " + id); //выбрасываем это исключение

        employeeService.deleteEmployee(id);//если есть такой работник, то удаляем из базы
        return "The employee with id " + id +" was deleted!";//возвращаем json

    }
}

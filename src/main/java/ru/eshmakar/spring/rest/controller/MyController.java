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


    @ExceptionHandler//аннотация для выбрасывания своих исключении
    public ResponseEntity<EmployeeIncorrectData> exceptionHandling(NoSuchEmployeeException exception){  //ResponseEntity - используется для добавления состояния HttpStatus
        EmployeeIncorrectData incorrectData = new EmployeeIncorrectData();  //создаем объект нашего класса
        incorrectData.setInfo(exception.getMessage());  //добавляем сообщение о том, что такого работника нет
        return new ResponseEntity<>(incorrectData, HttpStatus.BAD_REQUEST); //возвращаем сообщение в формате json со статусом BAD_REQUEST
    }

}

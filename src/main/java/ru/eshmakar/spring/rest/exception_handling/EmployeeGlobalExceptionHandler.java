package ru.eshmakar.spring.rest.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice   //наши Exception-ы будут совместно использоваться несколькими классами @Controller (то есть обработчики ошибок помещаем на глобальный уровень, не будем захламлять Controller классы
public class EmployeeGlobalExceptionHandler {
    @ExceptionHandler//аннотация для выбрасывания своих исключении
    public ResponseEntity<EmployeeIncorrectData> exceptionHandling(NoSuchEmployeeException exception){  //ResponseEntity - используется для добавления состояния HttpStatus
        EmployeeIncorrectData incorrectData = new EmployeeIncorrectData();  //создаем объект нашего класса
        incorrectData.setInfo(exception.getMessage());  //добавляем сообщение о том, что такого работника нет
        return new ResponseEntity<>(incorrectData, HttpStatus.NOT_FOUND); //возвращаем сообщение в формате json со статусом BAD_REQUEST
    }

    @ExceptionHandler
    public ResponseEntity<EmployeeIncorrectData> exceptionHandling(Exception exception){ //этот метод будет срабатывать для любого Exception
        EmployeeIncorrectData incorrectData = new EmployeeIncorrectData();
        incorrectData.setInfo(exception.getMessage());
        return new ResponseEntity<>(incorrectData, HttpStatus.BAD_REQUEST);
    }
}

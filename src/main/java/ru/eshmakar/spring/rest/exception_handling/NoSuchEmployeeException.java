package ru.eshmakar.spring.rest.exception_handling;


//этот класс будет использоваться для выбрасывания exception
public class NoSuchEmployeeException extends RuntimeException{

    public NoSuchEmployeeException(String message) {
        super(message);//сообщение будет установлено в контроллере
    }
}

package ru.eshmakar.spring.rest.exception_handling;

//этот класс будет использоваться при не правильном запросе id работника
public class EmployeeIncorrectData {
    private String info;

    public EmployeeIncorrectData() {
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}

package pro.sky.collections1.service;

import pro.sky.collections1.Employee;

import java.util.List;

public interface EmployeeService {

    Employee addEmployee(String firstName, String lastName);
    Employee removeEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);

    List<Employee> getAllEmployees();
}

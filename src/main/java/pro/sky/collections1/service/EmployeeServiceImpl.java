package pro.sky.collections1.service;

import org.springframework.stereotype.Service;
import pro.sky.collections1.Employee;
import pro.sky.collections1.exceptions.EmployeeAlreadyAddedException;
import pro.sky.collections1.exceptions.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final List<Employee> employees;

    public EmployeeServiceImpl() {
        employees = new ArrayList<>();
    }


    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }

        employees.add(employee);

        return employee;

        //throw new EmployeeStorageIsFullException();
    }


    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee);

        return employee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            return employee;
        } else {
            throw new EmployeeNotFoundException();
        }

    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }
}

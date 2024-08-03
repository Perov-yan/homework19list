package demo.list.list.test;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
public class EmployeeServiceImp implements EmployeeService {

    private final Set<Employee> employees;

    public EmployeeServiceImp(){
        employees = new HashSet<>();
    }

    @Override
    public Employee add(String firstName, String lastName){
        Employee newEmployee = new Employee(firstName,lastName);
        return add(newEmployee);
    }

    @Override
    public Employee add(Employee employee){
        if (employees.contains(employee)){
            throw new EmployeeExistsExeption();
        }

        employees.add(employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName){
        Employee newEmployee = new Employee(firstName, lastName);
        return remove(newEmployee);
    }

    @Override
    public Employee remove(Employee employee) {
        if (!employees.contains(employee)){
            throw new EmployeeNotFoundExeption();
        }

        employees.remove(employee);
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName){
        Employee newEmployee = new Employee(firstName, lastName);

        if (!employees.contains(newEmployee)){
            throw new EmployeeNotFoundExeption();
        }

        return newEmployee;
    }

    @Override
    public Collection<Employee> findAll(){
        return Collections.unmodifiableSet(employees);
    }
}

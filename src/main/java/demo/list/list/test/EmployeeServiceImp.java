package demo.list.list.test;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImp implements EmployeeService {

    private final Map<String, Employee> employees;

    public EmployeeServiceImp(){
        employees = new HashMap<>();
    }

    @Override
    public Employee add(String firstName, String lastName){
        Employee newEmployee = new Employee(firstName,lastName);

        if (employees.containsKey(firstName + lastName)){
         throw new EmployeeExistsExeption();
        }
        employees.put(firstName + lastName, newEmployee);
        return newEmployee;
    }

    @Override
    public Employee remove(String firstName, String lastName){
        if (!employees.containsKey(firstName + lastName)){
            throw new EmployeeNotFoundExeption();
        }

        return employees.remove(firstName + lastName);
    }


    @Override
    public Employee find(String firstName, String lastName){
        if (!employees.containsKey(firstName + lastName)){
            throw new EmployeeNotFoundExeption();
        }

        return employees.get(firstName + lastName);
    }

    @Override
    public Collection<Employee> findAll(){
        return Collections.unmodifiableCollection(employees.values());
    }
}

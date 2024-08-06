package demo.list.list.test;

import java.util.Collection;

public interface EmployeeService {

    Employee add(String firstName, String lastName, int departamentId, int salary);

    Employee remove(String firstName, String lastName);

    Employee find(String firstName, String lastName);

    Collection<Employee> findAll();
}

package demo.list.list.test;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;


public interface DepartamentService {
    Employee findEmployeeWithMaxSalary(int departamentId);

    Employee findEmployeeWithMinSalary(int departamentId);

    Map<Integer, List<Employee>> findEmployeeByDepartament();

    Collection<Employee> findEmployeeByDepartament(Integer departamentId);
}

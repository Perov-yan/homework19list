package demo.list.list.test;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class DepartamentServiceImpl implements DepartamentService {

    private  final EmployeeService employeeService;

    public DepartamentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee findEmployeeWithMaxSalary(int departamentId) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartamentId() == departamentId)
                .max(comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundExeption::new);
    }

    @Override
    public Employee findEmployeeWithMinSalary(int departamentId) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartamentId() == departamentId)
                .min(comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeExistsExeption::new);
    }

    @Override
    public Map<Integer, List<Employee>> findEmployeeByDepartament() {
        return employeeService.findAll().stream()
                .sorted(comparing(Employee::getLastName). thenComparing(Employee::getFirstName))
                .collect(groupingBy(Employee::getDepartamentId));
    }

    @Override
    public Collection<Employee> findEmployeeByDepartament(Integer departamentId) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartamentId() == departamentId)
                .sorted(comparing(Employee::getLastName).thenComparing(Employee::getFirstName))
                .collect(toList());
    }
}

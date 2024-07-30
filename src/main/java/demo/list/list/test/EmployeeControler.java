package demo.list.list.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeControler {

    private final EmployeeService employeeService;

    public EmployeeControler(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public String add(@RequestParam String firstName, @RequestParam String lastName) {
        Employee result = employeeService.add(firstName,lastName);
        return  generateMessage(result, " успешно создан");
    }

    @GetMapping(path = "/remove")
    public String remove(@RequestParam String firstName, @RequestParam String lastName) {
        Employee result = employeeService.remove(firstName,lastName);
        return  generateMessage(result, " удален");
    }

    @GetMapping(path = "/find")
    public Employee find(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.find(firstName, lastName);
    }

    @GetMapping
    public Collection<Employee> findAll(){
        return employeeService.findAll();
    }

    private String generateMessage(Employee employee, String status) {
        return String.format("Сотрудник %s %s %s",
                employee.getFirstName(),
                employee.getLastName(),
                status);
    }
}

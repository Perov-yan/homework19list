package demo.list.list.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/departaments")
public class DepartamentController {
    private final DepartamentService departamentService;

    public DepartamentController(DepartamentService departamentService) {
        this.departamentService = departamentService;
    }

    @GetMapping(path = "/max-salary")
    public Employee findEmployeeWithMaxSalaryByDepartamentId(@RequestParam int departamentId){
        return departamentService.findEmployeeWithMaxSalary(departamentId);
    }

    @GetMapping(path = "/min-salary")
    public Employee findEmployeeWithMinSalaryByDepartament(@RequestParam int departamentId){
        return departamentService.findEmployeeWithMinSalary(departamentId);
    }

    @GetMapping(path = "/all")
    public Map<Integer, List<Employee>> findEmployees(){
        return departamentService.findEmployeeByDepartament();
    }

    @GetMapping(path = "/all-departament")
    public Collection<Employee> findEmployees(@RequestParam int departamentId){
        return departamentService.findEmployeeByDepartament(departamentId);
    }
}

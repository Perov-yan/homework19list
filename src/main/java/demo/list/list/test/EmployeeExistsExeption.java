package demo.list.list.test;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class EmployeeExistsExeption extends RuntimeException {

    public EmployeeExistsExeption() {
        super("В книге сотрудников уже есть такой сотрудник");
    }

}

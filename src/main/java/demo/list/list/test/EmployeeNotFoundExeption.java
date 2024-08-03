package demo.list.list.test;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class EmployeeNotFoundExeption extends RuntimeException {
    private static final String DEFAULT_MESSAGE = "Сотрудник не найден";

    public EmployeeNotFoundExeption(){
        super(DEFAULT_MESSAGE);
    }

}

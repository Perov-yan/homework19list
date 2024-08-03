package demo.list.list.test;

import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;

    private int salary;
    private int departamentId;

    public Employee(String firstName, String lastName, int salary, int departamentId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.departamentId = departamentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getDepartamentId() {
        return departamentId;
    }

    public void setDepartamentId(int departamentId) {
        this.departamentId = departamentId;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Employee)) return false;
        Employee employee = (Employee) object;
        return departamentId == employee.departamentId && firstName.equals(employee.firstName) && lastName.equals(employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, departamentId);
    }

    @Override
    public String toString() {
        return String.format("Сотрудник %s %s из отдела № %d с зарплатой %d",
                lastName,
                firstName,
                departamentId,
                salary) ;
    }
}

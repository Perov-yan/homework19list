package demo.list.list.test;

import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;

    private int departamentId;
    private int salary;

    public Employee(String firstName, String lastName, int departamentId, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.departamentId = departamentId;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartamentId() {
        return departamentId;
    }

    public void setDepartamentId(int departamentId) {
        this.departamentId = departamentId;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        Employee employee = (Employee) object;
        return firstName.equals(employee.firstName) && lastName == employee.lastName;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "Сотрудник " + firstName + " " + lastName ;
    }
}

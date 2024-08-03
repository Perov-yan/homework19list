package demo.list.list.test;

import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
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

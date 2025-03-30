package pkg.yhan;

import java.time.LocalDate;
import java.util.Objects;


public class Employee {
    private final String name;
    private final double salary;
    private final LocalDate hireDate;

    /**
     *
     * @param name
     * @param salary
     * @param hireDate
     */
    public Employee(String name, double salary, LocalDate hireDate) {

        this.name = name;
        this.salary = salary;
        this.hireDate = hireDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(salary, employee.salary) == 0 && Objects.equals(name, employee.name) && Objects.equals(hireDate, employee.hireDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary, hireDate);
    }
}

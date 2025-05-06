package pkg.yhan;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
class EmployeeDBTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void update() {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("yi", 9007979, LocalDate.of(2020, 1, 1)));
        EmployeeDB employeeDB = new EmployeeDB();
        employeeDB.update(employees);
        ArrayList arrayList = employeeDB.find("");
        arrayList.forEach(System.out::println);

    }

    @Test
    void find() {
    }
}
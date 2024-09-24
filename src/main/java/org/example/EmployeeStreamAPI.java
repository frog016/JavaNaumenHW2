package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class EmployeeStreamAPI {
    private static final ArrayList<Employee> EMPLOYEES = new ArrayList<>(Arrays.asList(
            new Employee("Kirill Kirillov", 20, "Development", 100500),
            new Employee("Andrey Maximov", 41, "Art", 64200),
            new Employee("Nikita Fadeev", 90, "Finance", 403000),
            new Employee("Valery Noname", 34, "Art", 120322),
            new Employee("Ivan Ivanov", 18, "Support", 10000)
    ));

    public ArrayList<Employee> sortEmployeesBySalary() {
        ArrayList<Employee> employeesCopy = new ArrayList<>(EMPLOYEES);

        return new ArrayList<>(employeesCopy
                .stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .toList());
    }
}

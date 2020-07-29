package com.bgasparotto.datastructures.datastructure.list;

import java.util.ArrayList;
import java.util.List;

public class ArrayListUsageExample {

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(123, "Jane", "Jones"));
        employeeList.add(new Employee(4567, "John", "Doe"));
        employeeList.add(new Employee(22, "Mary", "Smith"));
        employeeList.add(new Employee(3245, "Mike", "Wilson"));

        employeeList.forEach(System.out::println);

        System.out.println(employeeList.get(1));

        System.out.println(employeeList.isEmpty());

        employeeList.set(1, new Employee(4568, "John", "Adams"));
        employeeList.forEach(System.out::println);

        System.out.println(employeeList.size());

        employeeList.add(3, new Employee(4567, "John", "Doe"));
        employeeList.forEach(System.out::println);

        Employee[] employeeArray = employeeList.toArray(new Employee[0]);
        for (Employee employee: employeeArray) {
            System.out.println(employee);
        }

        System.out.println(employeeList.contains(new Employee(22, "Mary", "Smith")));
        System.out.println(employeeList.indexOf(new Employee(4567, "John", "Doe")));

        employeeList.remove(2);
        employeeList.forEach(System.out::println);
    }
}

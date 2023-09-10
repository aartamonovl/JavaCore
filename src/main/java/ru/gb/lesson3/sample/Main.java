package ru.gb.lesson3.sample;

import ru.gb.lesson3.regular.*;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employeesF = Freelancer.getEmployees(4);
        List<Employee> employeesW = Worker.getEmployees(4);

        for (Employee employee : employeesF) {
            System.out.println(employee);
        }
        for (Employee employee : employeesW) {
            System.out.println(employee);
        }

        Collections.sort(employeesF, new EmployeeNameComparator());
        System.out.println();

        Collections.sort(employeesW, new EmployeeNameComparator());
        System.out.println();

        for (Employee employee : employeesF) {
            System.out.println(employee);
        }
        System.out.println();
        for (Employee employee : employeesW) {
            System.out.println(employee);
        }
        System.out.println();
        Collections.sort(employeesF, new EmployeeBirthdayComparator());
        System.out.println();

        Collections.sort(employeesW, new EmployeeBirthdayComparator());
        System.out.println();

        for (Employee employee : employeesF) {
            System.out.println(employee);
        }
        System.out.println();
        for (Employee employee : employeesW) {
            System.out.println(employee);
        }
        System.out.println();

        List<Employee> employeesAll = EmployeeAll.getEmployees();

        for (Employee employee : employeesAll) {
            System.out.println(employee);
        }

        Collections.sort(employeesAll, new EmployeeFullComparator());
        System.out.println();

        for (Employee employee : employeesAll) {
            System.out.println(employee);
        }
    }
}

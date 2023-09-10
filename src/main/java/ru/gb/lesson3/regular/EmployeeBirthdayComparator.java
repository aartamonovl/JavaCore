package ru.gb.lesson3.regular;

import java.util.Comparator;

public class EmployeeBirthdayComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getBirthday().compareTo(o2.getBirthday());
    }
}

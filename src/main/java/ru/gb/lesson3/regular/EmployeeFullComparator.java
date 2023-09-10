package ru.gb.lesson3.regular;

import java.util.Comparator;

public class EmployeeFullComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        int res = o1.getSurName().compareTo(o2.getSurName());
        if (res == 0) {
            res = o1.getName().compareTo(o2.getName());
            if (res == 0){
                res = o1.getBirthday().compareTo(o2.getBirthday());
                if (res == 0){
                    Double.compare(o1.calculateSalary(), o2.calculateSalary());
                }
                return res;
            }
        }
        return res;
    }
}

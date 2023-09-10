package ru.gb.lesson3.regular;

import java.util.*;
import java.util.function.Consumer;

public class EmployeeAll implements Iterable<Employee> {
    private static List<Employee> employees = new ArrayList<>();

    public static List<Employee> getEmployees() {
        return employees;
    }

    public static void setEmployee(Employee employee) {
        EmployeeAll.employees.add(employee);
    }

    public void aaa(){
//        EmployeeAll.employees.forEach(this);
    }

    @Override
    public Iterator<Employee> iterator() {
        return new Iterator<Employee>() {
            int i = 0;
            @Override
            public boolean hasNext() {
                return (i < employees.toArray().length && employees.toArray()[i] != null);
            }

            @Override
            public Employee next() {
                if (!hasNext()){
                    throw new NoSuchElementException();
                }
                return (Employee) employees.toArray()[i++];
            }
        };
    }

    @Override
    public void forEach(Consumer<? super Employee> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<Employee> spliterator() {
        return Iterable.super.spliterator();
    }
}

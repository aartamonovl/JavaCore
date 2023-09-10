package ru.gb.lesson3.regular;

import java.util.ArrayList;
import java.util.List;

public class Worker extends Employee {

    private Worker(String surName, String name, double salary, String birthday) {
        super(surName, name, salary, birthday);
    }

    public static Employee getInstance() {
        return new Worker(
                surNames[random.nextInt(surNames.length)],
                names[random.nextInt(surNames.length)],
                random.nextInt(30000, 250000),
                birthdays[random.nextInt(birthdays.length)]);
    }

    public static List<Employee> getEmployees(int count) {
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < count; i++)
            employees.add(getInstance());
        return employees;
    }

    @Override
    public double calculateSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s;Дата рождения: %s; Рабочий; Среднемесячная заработная плата (фиксированная месячная оплата): %.2f (руб.)",
                surName, name, birthday, salary);
    }
}

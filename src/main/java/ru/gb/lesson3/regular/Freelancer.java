package ru.gb.lesson3.regular;

import java.util.ArrayList;
import java.util.List;

public class Freelancer extends Employee {
    private Freelancer(String surName, String name, double salary, String birthday) {
        super(surName, name, salary, birthday);
    }

    private Freelancer(String surName, String name, double salary) {
        super(surName, name, salary, "01.01.1990");
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public static Employee getInstance() {
        return new Freelancer(
                surNames[random.nextInt(surNames.length)],
                names[random.nextInt(surNames.length)],
                random.nextInt(1000, 5000),
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
        return salary*8*20.8;
    }

    @Override
    public String toString() {
        return String.format("%s %s; Дата рождения: %s;Фрилансер; Среднемесячная заработная плата (в пересчете с почасовой ставки): %.2f (руб.)",
                surName, name, birthday, calculateSalary());
    }
}

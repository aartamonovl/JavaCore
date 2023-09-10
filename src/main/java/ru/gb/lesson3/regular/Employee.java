package ru.gb.lesson3.regular;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Employee implements Comparable<Employee> {

    //region Public Methods

    /**
     * Расчет среднемесячной заработной платы
     *
     * @return
     */
    public abstract double calculateSalary();

    @Override
    public int compareTo(Employee o) {
        return Double.compare(calculateSalary(), o.calculateSalary());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", salary=" + salary +
                ", birthday=" + birthday +
                '}';
    }

    //endregion

    //region Constructors And Initializers

    {
        id = ++counter;
    }

    private Employee() {
        this("#Surname#", "#Name#");
    }

    private Employee(String surName, String name) {
        this(surName, name, 1000, "01.01.1990");
    }

    protected Employee(String surName, String name, double salary, String birthday) {
        if (salary < 1000) {
            throw new RuntimeException("Ставка заработной платы должна быть не менее 1000");
        }
        this.surName = surName;
        this.name = name;
        this.salary = salary;
        this.birthday = birthday;
        EmployeeAll.setEmployee(this);
    }

    //endregion

    //region Getters and Setters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public double getSalary(){
        return salary;
    }
    public void setSalary(double salary) {
        if (salary < 0) {
            throw new RuntimeException("Уровень заработной платы должен быть не менее 0");
        }
        this.salary = salary;
    }

    //endregion

    //region Fields

    private int id;

    /**
     * Имя
     */
    protected String name;

    /**
     * Фамилия
     */
    protected String surName;

    /**
     * Ставка заработной платы
     */
    protected double salary;

    /**
     * Дата рождения
     */

    protected String birthday;

    //endregion

    //region Static Fields

    protected static String[] names = new String[]{"Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Клим", "Панкратий", "Рубен", "Герман"};
    protected static String[] surNames = new String[]{"Григорьев", "Фокин", "Шестаков", "Хохлов", "Шубин", "Бирюков", "Копылов", "Горбунов", "Лыткин", "Соколов"};
    protected static String[] birthdays = new String[]{"2000.05.05", "1985.05.12", "1997.03.08", "1997.17.02"};
    protected static Random random = new Random();
    private static int counter = 1000;

    //endregion

}


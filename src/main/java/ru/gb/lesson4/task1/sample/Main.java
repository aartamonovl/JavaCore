package ru.gb.lesson4.task1.sample;

import ru.gb.lesson4.task1.regular.*;

import java.util.Random;

public class Main {

    private static Random random = new Random();

    public static void main(String[] args) {

        try {
            Animal cat1 = new Cat("Персик");
            Animal cat2 = new Cat("Барсик");
            Animal[] animals = new Animal[]{cat1, cat2};
            for (int i = 0; i < animals.length; i++) {
                for (int j = 0; j < 10; j++) {
                    int k = random.nextInt(2);
                    try {
                        switch (k) {
                            case 0 -> {
                                animals[i].swim(j * 10);
                                System.out.printf("Животное проплыло %d метров.\n", j * 10);
                            }
                            case 1 -> {
                                animals[i].run(j * 10);
                                System.out.printf("Животное пробежало %d метров.\n", j * 10);
                            }
                        }
                    } catch (AnimalRunException | AnimalSwimException e) {
                        System.out.printf("Ошибка при попытке %s пробежать %d метров (%s)\n", e.getName(), e.getDistance(), e.getMessage());
                    }
//                    catch (AnimalSwimException e){
//                        //System.out.printf("Ошибка при попытке %s проплыть %d метров (%s)\n", e.getName(), e.getDistance(), e.getMessage());
//                    }
                }
            }

        } catch (AnimalNameException e) {
            System.out.println(e.getMessage());
        }


    }

}

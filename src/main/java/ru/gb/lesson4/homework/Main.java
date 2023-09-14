package ru.gb.lesson4.homework;

import java.util.Random;

public class Main {

    private static Random random = new Random();
    private static String[][] strArray;

    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        createArray();
        fillInArray();
        if (!checkSizeArray()) {
            print();
            throw new MyArraySizeException("Неверный размер массива");
        }
        else {
            try {
                int sum = 0;
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        sum += parseInt(i, j);
                    }
                }
                System.out.printf("Сумма чисел в массиве равна: %d", sum);
                System.out.println();
            } catch (MyArrayDataException e) {
                throw new MyArrayDataException("Ошибка при попытке преобразовать строковый тип к целочисленному типу в ячейке [" + e.getI() + "][" + e.getJ() + "]", e.getI(), e.getJ());
            } finally {
                print();
            }
        }
    }

    private static void print() {
        for (int i = 0; i < strArray.length; i++) {
            for (int j = 0; j < strArray[0].length; j++) {
                System.out.printf("%s ", strArray[i][j]);
            }
            System.out.println();
        }
    }

    private static void createArray() {
        int row = randomSize();
        int col = randomSize();
        strArray = new String[row][col];
    }

    private static void fillInArray() {
        for (int i = 0; i < strArray.length; i++) {
            for (int j = 0; j < strArray[0].length; j++) {
                strArray[i][j] = String.valueOf(random.nextInt(10));
            }
        }
        if (random.nextInt(2) == 1)
            strArray[random.nextInt(strArray.length)][random.nextInt(strArray[0].length)] = "sss";
    }

    private static int randomSize() {
        int rnd = random.nextInt(1, 101);
        if (rnd < 10) {
            return 3;
        } else if (rnd < 20) {
            return 5;
        }
        return 4;
    }

    private static boolean checkSizeArray() {
        return strArray.length == 4 && strArray[0].length == 4;
    }

    private static int parseInt(int i, int j) throws MyArrayDataException {
        try {
            return Integer.parseInt(strArray[i][j]);
        } catch (NumberFormatException e) {
            throw new MyArrayDataException("Некорректный символ в ячейке", i, j);
        }
    }


}

class MyArrayDataException extends Exception {
    private final int i, j;

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    /**
     * Исключение при неудачном преобразовании
     *
     * @param message - сообщение об ошибке
     * @param i       - номер строки
     * @param j       - номер столбца
     */
    public MyArrayDataException(String message, int i, int j) {
        super(message);
        this.i = i;
        this.j = j;
    }
}

class MyArraySizeException extends Exception {

    /**
     * Исключение при не верном размере массива
     *
     * @param message - сообщение об ошибке
     */
    public MyArraySizeException(String message) {
        super(message);
    }
}

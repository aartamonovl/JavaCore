package ru.gb.lesson4.task1.regular;

public class AnimalRunException extends AnimalActionException {
    public AnimalRunException(String message, String name, int distance) {
        super(message, name, distance);
    }
}

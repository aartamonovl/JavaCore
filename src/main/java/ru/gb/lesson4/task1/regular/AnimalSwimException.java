package ru.gb.lesson4.task1.regular;

public class AnimalSwimException extends AnimalActionException {
    public AnimalSwimException(String message, String name, int distance) {
        super(message, name, distance);
    }
}

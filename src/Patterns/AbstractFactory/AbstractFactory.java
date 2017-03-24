package Patterns.AbstractFactory;

interface Color {
    void fill();
}

public abstract class AbstractFactory {
    abstract Color getColor(String color);
    abstract Shape getShape(String shape);
}


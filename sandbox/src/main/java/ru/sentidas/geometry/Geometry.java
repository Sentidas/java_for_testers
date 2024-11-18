package ru.sentidas.geometry;

import ru.sentidas.geometry.figures.Rectangle;
import ru.sentidas.geometry.figures.Square;

public class Geometry {

    public static void main(String[] args) {
        Square.printSquareArea(new Square(8.0));
        Square.printSquareArea(new Square(5.5));
        Rectangle.printRectangleArea(new Rectangle(4.0,5.0));
        Rectangle.printRectangleArea(new Rectangle(3.2,8.7));
    }

 }

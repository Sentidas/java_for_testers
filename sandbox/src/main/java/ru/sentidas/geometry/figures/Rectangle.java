package ru.sentidas.geometry.figures;

public class Rectangle {


    public static void printRectangleArea(double a, double b) {
        System.out.println("Площадь прямоугольника со стороной "
                + a + " и " + b + " = " + rectangleArea(a,b));
    }

    private static double rectangleArea(double a, double b) {
       return a * b;
    }
}

package ru.sentidas.geometry.figures;

public record Rectangle(
        double a,
        double b
) {

    public static void printRectangleArea(Rectangle rectangle) {
        String text = String.format("Площадь прямоугольника со стороной %f и %f = %f",
                rectangle.a, rectangle.b, rectangle.area());
        System.out.println(text);
    }

    public double area() {
       return this.a * this.b;
    }
}

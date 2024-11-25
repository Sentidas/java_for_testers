package ru.sentidas.geometry.figures;

public record Rectangle(
        double a,
        double b
) {

    public Rectangle {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("Rectangle side should be non-negative");
        }
    }

    public static void printRectangleArea(Rectangle rectangle) {
        String text = String.format("Площадь прямоугольника со стороной %.2f и %.2f = %.2f",
                rectangle.a, rectangle.b, rectangle.area());
        System.out.println(text);
    }

    public double area() {
       return this.a * this.b;
    }
}

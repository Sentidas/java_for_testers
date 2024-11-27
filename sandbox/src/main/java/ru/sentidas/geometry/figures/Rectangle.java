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



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return (Double.compare(this.a, rectangle.a) == 0 && Double.compare(this.b, rectangle.b) == 0)
                || (Double.compare(this.b, rectangle.a) == 0 && Double.compare(this.a, rectangle.b) == 0) ;
    }

    @Override
    public int hashCode() {
        return 1;
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

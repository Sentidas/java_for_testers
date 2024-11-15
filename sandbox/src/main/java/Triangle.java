 public class Triangle {
    public static void main(String[] args) {
        printSquareArea(8.0);
        printRectangleArea(4.0,5.0);
        printRectangleArea(3.0,8.0);
    }

     private static void printRectangleArea(double a, double b) {
         System.out.println("Площадь прямоугольника со стороной "
                 + a + " и " + b + " = " + rectangleArea(a,b));
     }

     private static double rectangleArea(double a, double b) {
        return a * b;
     }

     private static void printSquareArea(double side) {
        System.out.println("Площадь квадрата со стороной " + side + " = " + squareArea(side));
    }

     private static double squareArea(double a) {
         return a * a;
     }
 }

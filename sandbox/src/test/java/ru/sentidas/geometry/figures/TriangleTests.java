package ru.sentidas.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {

    @Test
    void canCalculateArea() {
        Assertions.assertEquals(14.142135623730951, new Triangle(5,6,9).area());
    }

    @Test
    void canCalculatePerimeter() {
        Assertions.assertEquals(20.0, new Triangle(5,6,9).perimeter());
    }

    @Test
    void cannotCreateTriangleWithNegativeSideA() {
        try {
            new Triangle(-5.0, 6.0, 9.0);
            Assertions.fail();
        } catch (IllegalArgumentException e) {
            //OK
        }
    }

        @Test
    void cannotCreateTriangleWithNegativeSideB() {
        try {
            new Triangle(5.0, -6.0, 9.0);
            Assertions.fail();
        } catch (IllegalArgumentException e) {
            //OK
        }
    }

    @Test
    void cannotCreateTriangleWithNegativeSideC() {
        try {
            new Triangle(5.0, 6.0, -9.0);
            Assertions.fail();
        } catch (IllegalArgumentException e) {
            //OK
        }
    }

    @Test
    void cannotCreateTriangleWithSumOfTwoSideIsLessThird() {
        try {
            new Triangle(3.0, 2.0, 8.0);
            Assertions.fail();
        } catch (IllegalArgumentException e) {
            //OK
        }
    }
}

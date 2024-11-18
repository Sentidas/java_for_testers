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
}

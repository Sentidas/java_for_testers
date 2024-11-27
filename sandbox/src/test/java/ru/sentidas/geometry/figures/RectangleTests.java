package ru.sentidas.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RectangleTests {

    @Test
    void canCalculateArea(){
        var r = new Rectangle(4,5);
        Assertions.assertEquals(20, r.area());
    }

    @Test
    void cannotCreateRectangleWithNegativeSide() {
        try {
            new Rectangle(-5.0, 3.0);
            Assertions.fail();
        } catch (IllegalArgumentException e) {
            //OK
        }
    }

    @Test
    void testEquality() {
        var r1 = new Rectangle(5, 7);
        var r2 = new Rectangle(5, 7);
        // Assertions.assertTrue(r1.equals(r2));
        Assertions.assertEquals(r1, r2);
    }

    @Test
    void testEquality2() {
        var r1 = new Rectangle(5, 7);
        var r2 = new Rectangle(7, 5);
        Assertions.assertEquals(r1, r2);
    }
}

package ru.sentidas.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RectangleTests {

    @Test
    void canCalculateArea(){
        var r = new Rectangle(4,5);
        Assertions.assertEquals(20, r.area());
    }
}

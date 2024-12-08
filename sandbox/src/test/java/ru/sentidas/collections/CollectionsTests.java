package ru.sentidas.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CollectionsTests {

    @Test
    void arrayTests() {
        var strings = new String[]{"a","b","c"};

        Assertions.assertEquals("a",strings[0] );
        Assertions.assertEquals("b",strings[1] );
        Assertions.assertEquals("c",strings[2] );
        Assertions.assertEquals(3,strings.length);


        strings[0] = "d";
        Assertions.assertEquals("d",strings[0] );
    }

    @Test
    void listTests() {
        var list = new ArrayList<String>();
        Assertions.assertEquals(0,list.size());

        list.add("a");
        list.add("b");
        list.add("c");

        var list2 = List.of("a","b","c"); // список который так создан является неизменяемым но заранее
        // проинициилизирован
        Assertions.assertEquals("a",list2.get(0));

        // чтобы сразу инициализировать и иметь возможность изменять можно так

        var list3 = new ArrayList<>(List.of("a","b","c"));




    }

}

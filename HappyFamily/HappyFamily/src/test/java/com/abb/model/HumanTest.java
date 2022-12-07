package com.abb.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class HumanTest {

    @Test
    void testToString() {
        Human human = new Human("Michael","Karleone", 1970 );
        String expected = "Human{\n" +
                "   name='Michael',\n" +
                "   surname='Karleone',\n" +
                "   year=1970,\n" +
                "   iq=null,\n" +
                "   pet=null,\n" +
                "   mother=null,\n" +
                "   father=null,\n" +
                "   schedule=null\n" +
                '}';

        String actual = human.toString();
        assertEquals(expected, actual);


    }
}
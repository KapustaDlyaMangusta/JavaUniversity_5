package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextModifierTest {

    @Test
    void modify() {
        var text = "Ou love me? Do what lalalalalalala o!";

        var textModifier = new TextModifier();
        var result = textModifier.Modify(text);


        assertEquals("love Ou me? Do what o lalalalalalala!", result);
    }
}
package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SentenceTest {

    @Test
    void replaceFirstVowelWordWithLongestWord() {
        String sentence = "I dont like rabbitttttttts at all";

        var a = Sentence.Create(sentence);

        a.replaceFirstVowelWordWithLongestWord();

        assertEquals("rabbitttttttts dont like I at all", a.getValue());
    }
}
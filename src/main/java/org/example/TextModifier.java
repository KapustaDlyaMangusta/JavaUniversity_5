package org.example;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class TextModifier {

    public String Modify(String text){
        Pattern pattern = Pattern.compile("[^.!?]+[.!?]");

        List<String> sentences = pattern
                .matcher(text)
                .results()
                .map(MatchResult::group)
                .toList();

        StringBuilder result = new StringBuilder();
        sentences.stream()
                .map(Sentence::Create)
                .map(sentence -> {
                    sentence.replaceFirstVowelWordWithLongestWord();
                    return sentence.getValue();
                })
                .forEach(result::append);

        return result.toString();
    }
}

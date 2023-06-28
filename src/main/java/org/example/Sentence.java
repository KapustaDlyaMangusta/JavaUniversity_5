package org.example;

import lombok.Getter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Pattern;

public class Sentence {
    private Sentence(String value){
        Value = value;
    }

    @Getter
    private String Value;

    public void replaceFirstVowelWordWithLongestWord(){
        var inputString = Value;
        var vowelWord = "";
        var longestWord = "";

        var vowelMatcher = Pattern.compile("\\b[aeiou]\\w*\\b", Pattern.CASE_INSENSITIVE)
                .matcher(inputString);
        if (vowelMatcher.find()) {
            vowelWord = vowelMatcher.group().replaceAll("[^a-zA-Z0-9\\d]", "");
        }

        var words = inputString.split("\\s+");
        longestWord = Arrays.stream(words)
                .max(Comparator.comparing(String::length))
                .map(m -> m.replaceAll("[^a-zA-Z0-9\\d]", ""))
                .orElse("");

        var regex = "\\b(" + vowelWord + "|" + longestWord + ")\\b";
        var replacementMatcher = Pattern.compile(regex).matcher(inputString);

        var buffer = new StringBuffer();
        while (replacementMatcher.find()) {
            var word = replacementMatcher.group();
            if (word.equals(vowelWord)) {
                replacementMatcher.appendReplacement(buffer, longestWord);
            } else {
                replacementMatcher.appendReplacement(buffer, vowelWord);
            }
        }
        replacementMatcher.appendTail(buffer);

        Value = buffer.toString();
    }

    public static Sentence Create(String value){
       if(value.isEmpty()){
           throw new IllegalArgumentException("Sentence cannot be created with empty value");
       }

       return new Sentence(value);
    }
}

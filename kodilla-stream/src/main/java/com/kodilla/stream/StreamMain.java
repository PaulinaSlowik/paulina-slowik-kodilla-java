package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;

public class StreamMain {
    public static void main(String[] args) {
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        poemBeautifier.beautify("Text for decoration",(textForDecoration -> textForDecoration.toUpperCase()));
        poemBeautifier.beautify("Text for decoration", (textForDecoration -> "AAA "+textForDecoration+" aaa"));
        poemBeautifier.beautify("Text for decoration", (textForDecoration -> "AAA "+textForDecoration.replace("a","A")));
        poemBeautifier.beautify("Text for decoration",(textForDecoration -> "Text has " +textForDecoration.length() + " letters"));
        poemBeautifier.beautify("Text for decoration",(textForDecoration -> "Start: " +textForDecoration + "... End"));
        poemBeautifier.beautify("Text for decoration",(textForDecoration -> textForDecoration.concat(" ").concat("x2")));

    }
}



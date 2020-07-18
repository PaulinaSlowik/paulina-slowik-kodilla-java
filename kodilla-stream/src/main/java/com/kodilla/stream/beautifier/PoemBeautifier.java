package com.kodilla.stream.beautifier;

public class PoemBeautifier {
    public void beautify (String textForDecoration, PoemDecorator poemDecorator){
        String result = poemDecorator.decorate(textForDecoration);
        System.out.println(result);
    }
}

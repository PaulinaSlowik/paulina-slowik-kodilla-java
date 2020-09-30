package com.kodilla.patterns.builder.checkers;

public class Board {
    //Klasa planszy definiuje dwie stałe: MIN_INDEX oraz MAX_INDEX, z których mogą korzystać klasy zewnętrzne, aby określić, jak duża jest plansza.
    //Plansza obecnie ma 10x10 elementów, indeksy mogą mieć więc zakres od 0 do 9.
    public final static int MIN_INDEX = 0;
    public final static int MAX_INDEX = 9;
    //Kluczowym elementem klasy Board jest dwuwymiarowa tablica board, której elementami mogą być obiekty typu Figure
    Figure[][] board = new Figure[10][];

    //konstruktor inicjujący pustą planszę
    public Board() {
        for (int n = 0; n < 10; n++) {
            board[n] = new Figure[10];
        }
    }

    //getter pozwalający pobierać figurę z danego miejsca planszy
    public Figure getFigure(int x, int y) {
        return board[x][y];
    }

    //setter pozwalający do danego miejsca planszy figurę przypisać
    public void setFigure(Figure figure, int x, int y) {
        board[x][y] = figure;
    }

    //toString dzięki któremu można wyświetlić planszę wraz z figurami.
    //Figury reprezentowane są przez teksty w postaci "bQ", co oznacza czarną damkę (black Queen)
    public String toString() {
        String result = "";
        for(int n = MIN_INDEX; n <= MAX_INDEX; n++) {
            result += "|";
            for(int k = MIN_INDEX; k <= MAX_INDEX; k++) {
                if(board[n][k] == null) {
                    result += "  ";
                } else {
                    result += (board[n][k]).getColor().equals(Figure.BLACK) ? "b" : "w";
                    result += (board[n][k]) instanceof Pawn ? "P" : "Q";
                }
                result += "|";
            }
            result += "\n";
        }
        return result;
    }
}
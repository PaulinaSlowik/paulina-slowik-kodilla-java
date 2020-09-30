package com.kodilla.patterns.builder.checkers;

public class Checkers {
    private final Board board;
    private final String playerOne;
    private final String playerTwo;
//prywatny konstruktor, który może być wywołany jedynie z wewnętrznej klasy CheckersBuilder
    private Checkers(Board board, String playerOne, String playerTwo) {
        this.board = board;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public Board getBoard() {
        return board;
    }

    public String getPlayerOne() {
        return playerOne;
    }

    public String getPlayerTwo() {
        return playerTwo;
    }
//kod wewnętrznej klasy statycznej CheckersBuilder
    public static class CheckersBuilder {
        private Board board = new Board();
        private String playerOne = "";
        private String playerTwo = "";

        public CheckersBuilder PlayerOne(String playerOne) {
            this.playerOne = playerOne;
            return this;
        }

        public CheckersBuilder PlayerTwo(String playerTwo) {
            this.playerTwo = playerTwo;
            return this;
        }
//metoda, która tworzy nową figurę i wstawia ją na planszę w miejscu o współrzędnych x, y. Metoda ta sprawdza czy wartości x i y mieszczą się w dozwolonych przedziałach. Jeżeli nie, generowany jest wyjątek IllegalStateException
        public CheckersBuilder Figure(String figureType, String figureColor, int x, int y) {
            if (x > Board.MAX_INDEX || x < Board.MIN_INDEX ||
                    y > Board.MAX_INDEX || y < Board.MIN_INDEX) {
                throw new IllegalStateException("x and y should be in range between " +
                        Board.MIN_INDEX + " and " + Board.MAX_INDEX);
            }
            if (board.getFigure(x, y) == null) {
                board.setFigure(FigureFactory.makeFigure(figureType, figureColor), x, y);
            } else {
                throw new IllegalStateException("Position " + x + "," + y + " is already occupied");
            }
            return this;
        }
//metoda build(), która przed utworzeniem obiektu klasy Checkers dokonuje szeregu walidacji:
        public Checkers build() {
            //sprawdza, czy zainicjowano wartość zmiennej playerOne
            if (playerOne.length() == 0) {
                throw new IllegalStateException("There is no player One specified!");
            }
            //sprawdza, czy zainicjowano wartość zmiennej playerTwo
            if (playerTwo.length() == 0) {
                throw new IllegalStateException("There is no player Two specified");
            }
            //sprawdza, czy na planszy znajduje się co najmniej po jednej figurze z każdego koloru (BLACK oraz WHITE)
            boolean white = false, black = false;
            for(int x = Board.MIN_INDEX; x <= Board.MAX_INDEX; x++) {
                for(int y = Board.MIN_INDEX; y <= Board.MAX_INDEX; y++) {
                    Figure figure = board.getFigure(x, y);
                    if (figure != null) {
                        if (figure.getColor().equals(Figure.BLACK)) {
                            black = true;
                        } else {
                            white = true;
                        }
                    }
                }
            }
            if (!(black && white)) {
                throw new IllegalStateException("There are no figures of both colors on the board!");
            }
            //tworzymy obiekt klasy Checkers i go zwraca
            return new Checkers(board, playerOne, playerTwo);
        };
    }
}
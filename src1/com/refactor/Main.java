package com.refactor;

public class Main {

    public static int [][]  board = new int[8][8];
    public static int actingFigure = 1;

    public static void main(String[] args) {
        CheckersBoard checkersBoardObject = new CheckersBoard();
        checkersBoardObject.checkersBoard();
    }
}

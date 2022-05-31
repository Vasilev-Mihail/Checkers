package com.refactor;

import static com.refactor.Main.actingFigure;
import static com.refactor.Main.board;

public class Draw {

    public void draw(){
        int buffCount = 0;
        int indexFigure;
        if (actingFigure == 2){
            indexFigure = 1;
        }
        else indexFigure = -1;
        for (int j = 0; j <= 7; j++) {
            for (int i = 0; i <= 7; i++) {
                if (board[i][j] == actingFigure){
                    if (i + 1 <= (board.length / 10) - 1){
                        if (board[i + 1][j + indexFigure] == 0){
                            buffCount++;
                        }
                    }
                    else if (i - 1 >= 0){
                        if (board[i - 1][j + indexFigure] == 0){
                            buffCount++;
                        }
                    }
                }
                else if (board[i][j] == actingFigure + 2){
                    if (i + 1 <= (board.length / 10) - 1 && j + 1 <= (board.length / 10) - 1){
                        if (board[i + 1][j + 1] == 0){
                            buffCount++;
                        }
                    }
                    else if (i - 1 >= 0 && j + 1 <= (board.length % 10) - 1){
                        if (board[i - 1][j + 1] == 0){
                            buffCount++;
                        }
                    }
                    else if (i - 1 >= 0 && j - 1 >= 0){
                        if (board[i - 1][j - 1] == 0){
                            buffCount++;
                        }
                    }
                    else if (i + 1 >= (board.length / 10) - 1 && j - 1 >= 0){
                        if (board[i + 1][j - 1] == 0){
                            buffCount++;
                        }
                    }
                }
            }
        }
        if (buffCount == 0){
            System.out.println(" Draw ");
            CheckersBoard checkersBoardObject = new CheckersBoard();
            checkersBoardObject.checkersBoard();
        }
    }
}

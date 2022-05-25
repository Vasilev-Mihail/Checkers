package com.refactor;

import java.util.Scanner;

public class ActionMove {

    public void actionMove(int select, boolean flag) {
        Scanner console;

        console = new Scanner(System.in);

        int move = console.nextInt();


        if (select / 10 > Main.board.length - 1 || select % 10 > Main.board.length - 1 ||
                Main.board[select / 10][select % 10] == 5 || Main.board[select / 10][select % 10] == 0){
            System.out.println("Error in select");
            Arbitrator arbitratorObject = new Arbitrator();
            arbitratorObject.arbitrator();
        }
        else if (move / 10 > Main.board.length - 1 || move % 10 > Main.board.length - 1 || Main.board[move / 10][move % 10] == 5){
            System.out.println("Error in move");
            actionMove(select, flag);
        }
        else if (Main.board[select / 10][select % 10] == Main.actingFigure ||
                Main.board[select / 10][select % 10] == Main.actingFigure + 2){
            if (Main.board[select / 10][select % 10] > 2){
                King kingObject = new King();
                kingObject.king(select, move, flag);
            }
            else {
                CheckersFigure checkersFigureObject = new CheckersFigure();
                checkersFigureObject.checkersFigure(select, move, flag);
            }
        }
        else {
            System.out.println(" Error target ");
            Arbitrator arbitratorObject = new Arbitrator();
            arbitratorObject.arbitrator();
        }
    }
}

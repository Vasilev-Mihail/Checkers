package com.game;

import java.util.Scanner;


public class Checkers {

    public static int [][]  board = new int[8][8];
    public static int actingFigure = 1;
    public static int actingKingFigure = actingFigure + 2;

    public static void checkersBoard() {

//        for (int j = 0; j <= 7; j++) {
//            for (int i = 0; i <= 7; i++) {
//                if ((i + j + 1) % 2 != 0) {
//                    board[i][j] = 5;
//                } else {
//                    if (j <= 2) {
//                        board[i][j] = 2;
//                    } else if (j >= 5) {
//                        board[i][j] = 1;
//                    } else {
//                        board[i][j] = 0;
//                    }
//                }
//            }
//        }

        for (int j = 0; j <= 7; j++) {
            for (int i = 0; i <= 7; i++) {
                if ((i + j + 1) % 2 != 0) {
                    board[i][j] = 5;
                } else {
                    if (j == 2) {
                        board[i][j] = 4;
                    } else if (j == 5) {
                        board[i][j] = 3;
                    } else {
                        board[i][j] = 0;
                    }
                }
            }
        }

        Checkers.actionSelect();
    }

    public static void actionSelect(){
        Scanner console;
        console = new Scanner(System.in);

        for (int j = 0; j <= 7; j++) {
            for (int i = 0; i <= 7; i++) {
                if (j == 7 && board[i][j] == 2){
                    board[i][j] = 4;
                }
                else if(j == 0 && board[i][j] == 1){
                    board[i][j] = 3;
                }
                System.out.print(board[i][j]);
            }
            System.out.println();
        }

        int select = console.nextInt();
        Checkers.actionMove(select);
    }

    public static void actionMove(int select) {
        Scanner console;
        while (true) {

            console = new Scanner(System.in);

            int move = console.nextInt();

            if (select / 10 > board.length - 1 || select % 10 > board.length - 1 ||
                    board[select / 10][select % 10] == 5 || board[select / 10][select % 10] == 0){
                System.out.println("Error in select");
                Checkers.actionSelect();
            }
            else if (move / 10 > board.length - 1 || move % 10 > board.length - 1 || board[move / 10][move % 10] == 5){
                System.out.println("Error in move");
                Checkers.actionMove(select);
            }
            else if (board[select / 10][select % 10] == actingFigure ||
                    board[select / 10][select % 10] == actingKingFigure){
                if (board[select / 10][select % 10] > 2){
                    Checkers.figureO(select, move);
                }
                else {
                    Checkers.One(select, move);
                }
            }
        }
    }

    public static void One(int select, int move){

        int i = select / 10;
        int j = select % 10;

        if ((move == (i - 1) * 10 + (j - 1) || move == (i + 1) * 10 + (j - 1)) &&
                board[move / 10][move % 10] == 0){
            System.out.println("Всё очень плохо №1");
            board[move / 10][move % 10] = board[select / 10][select % 10];
            board[select / 10][select % 10] = 0;
            if (actingFigure == 1){
                actingFigure += 1;
            }
            else actingFigure -= 1;
            Checkers.actionSelect();
        }
        else if ((move == (i - 1) * 10 + (j + 1) || move == (i + 1) * 10 + (j + 1)) &&
                board[move / 10][move % 10] == 0){
            System.out.println("Всё очень плохо №2");
            board[move / 10][move % 10] = board[select / 10][select % 10];
            board[select / 10][select % 10] = 0;
            if (actingFigure == 1){
                actingFigure += 1;
            }
            else actingFigure -= 1;
            Checkers.actionSelect();
//            Переработка
        }
        else if((move == (i - 2) * 10 + (j + 2) || move == (i + 2) * 10 + (j + 2) ||
                move == (i - 2) * 10 + (j - 2) || move == (i + 2) * 10 + (j - 2)) &&
                (board[move / 10][move % 10] == 0)){
            if (select - move == -18 && ((board[(move - 9) / 10][(move - 9) % 10] != actingFigure ||
                    board[(move - 9) / 10][(move - 9) % 10] != actingKingFigure) &&
                    board[(move - 9) / 10][(move - 9) % 10] != 0)){
                board[(move - 9) / 10][(move - 9) % 10] = 0;
                board[move / 10][move % 10] = board[select / 10][select % 10];
                board[select / 10][select % 10] = 0;
                Checkers.nextMove(move);
            }
            else if (select - move == -22 && (board[(move - 11) / 10][(move - 11) % 10] != actingFigure ||
                    board[(move - 11) / 10][(move - 11) % 10] != actingKingFigure) &&
                    board[(move - 11) / 10][(move - 11) % 10] != 0){
                board[(move - 11) / 10][(move - 11) % 10] = 0;
                board[move / 10][move % 10] = board[select / 10][select % 10];
                board[select / 10][select % 10] = 0;
                Checkers.nextMove(move);
            }
            else if (select - move == 22 && (board[(move + 11) / 10][(move + 11) % 10] != actingFigure ||
                    board[(move + 11) / 10][(move + 11) % 10] != actingKingFigure) &&
                    board[(move + 11) / 10][(move + 11) % 10] != 0){
                board[(move + 11) / 10][(move + 11) % 10] = 0;
                board[move / 10][move % 10] = board[select / 10][select % 10];
                board[select / 10][select % 10] = 0;
                Checkers.nextMove(move);
            }
            else if (select - move == 18 && (board[(move + 9) / 10][(move + 9) % 10] != actingFigure ||
                    board[(move + 9) / 10][(move + 9) % 10] != actingKingFigure) &&
                    board[(move + 9) / 10][(move + 9) % 10] != 0){
                board[(move + 9) / 10][(move + 9) % 10] = 0;
                board[move / 10][move % 10] = board[select / 10][select % 10];
                board[select / 10][select % 10] = 0;
                Checkers.nextMove(move);
            }
            else {
                System.out.println("FF");
            }
//            Дальше норм
        }
    }
    public static void figureO (int select, int move){
        if (((select - move) % 11 == 0 || (select - move) % 9 == 0) && board[move / 10][move % 10] == 0){

            int buffMove = move;
            int buffSM;
            int buffShitAgan = board[select / 10][select % 10];
            boolean escalate = true;
            boolean target = false;

            if ((select - move) % 11 == 0 && select - move < 0){
                buffSM = -11;
            }
            else if ((select - move) % 11 == 0 && select - move > 0){
                buffSM = 11;
            }
            else if ((select - move) % 9 == 0 && select - move > 0){
                buffSM = 9;
            }
            else {
                buffSM = -9;
            }

            while (buffMove != select && escalate){
                if (board[buffMove / 10][buffMove % 10] == 0){
                    buffMove = buffMove + buffSM;
                }
                else if (board[buffMove / 10][buffMove % 10] == actingFigure ||
                        board[buffMove / 10][buffMove % 10] == actingKingFigure){
                    escalate = false;
                }
                else if (board[buffMove / 10][buffMove % 10] != actingFigure ||
                        board[buffMove / 10][buffMove % 10] != actingKingFigure){
                    buffMove = buffMove + buffSM;
                    if (board[buffMove / 10][buffMove % 10] == 0){
                        board[(buffMove - buffSM) / 10][(buffMove - buffSM) % 10] = 0;
                        board[buffMove / 10][buffMove % 10] = board[select / 10][select % 10];
                        board[select / 10][select % 10] = 0;
                        target = true;
                    }
                    else {
                        escalate = false;
                    }
                }
            }
            if (escalate){
                board[move / 10][move % 10] = buffShitAgan;
                board[select / 10][select % 10] = 0;
                if (target){
                    Checkers.nextMove(move);
                }
                else if (actingFigure == 1){
                    actingFigure += 1;
                    Checkers.actionSelect();
                }
                else {
                    actingFigure -= 1;
                    Checkers.actionSelect();
                }
            }
            else System.out.println("Error in KF");
        }
    }
    public static void nextMove(int move){
        if (move / 10 != 7 || move % 10 != 0){
            if (board[(move + 9) / 10][(move + 9) % 10] != actingFigure &&
                    board[(move + 9) / 10][(move + 9) % 10] != 0 &&
                    board[(move + 18) / 10][(move + 18) % 10] != actingFigure &&
                    board[(move + 18) / 10][(move + 18) % 10] != 0){

            }
        }
        else if (move / 10 != 0 || move % 10 != 0){
            if (board[(move - 11) / 10][(move - 11) % 10] != actingFigure &&
                    board[(move - 11) / 10][(move - 11) % 10] != 0 &&
                    board[(move - 22) / 10][(move - 22) % 10] != actingFigure &&
                    board[(move - 22) / 10][(move - 22) % 10] != 0){

            }
        }
        else if (move / 10 != 7 || move % 10 != 7){
            if (board[(move + 11) / 10][(move + 11) % 10] != actingFigure &&
                    board[(move + 11) / 10][(move + 11) % 10] != 0 &&
                    board[(move + 22) / 10][(move + 22) % 10] != actingFigure &&
                    board[(move + 22) / 10][(move + 22) % 10] != 0){

            }
        }
        else if (move / 10 != 0 || move % 10 != 7){
            if (board[(move - 9) / 10][(move - 9) % 10] != actingFigure &&
                    board[(move - 9) / 10][(move - 9) % 10] != 0 &&
                    board[(move - 18) / 10][(move - 18) % 10] != actingFigure &&
                    board[(move - 18) / 10][(move - 18) % 10] != 0){

            }
        }
        else Checkers.actionSelect();
    }
}

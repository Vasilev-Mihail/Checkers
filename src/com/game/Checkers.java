package com.game;

import java.util.Scanner;


public class Checkers {

     static String [][]  board = new String[8][8];
    public static String actingFigure = " 1 ";
    public static String kingActingFigure = " O ";

    public static void checkersBoard() {

//        Поле оформлено с ошибкой, алгоритм следует исправить
//        Ошибка устранена

//        Рабочее заполнение.

//        for (int j = 0; j <= 7; j++) {
//            for (int i = 0; i <= 7; i++) {
//                if ((i + j + 1) % 2 != 0) {
//                    board[i][j] = " X ";
//                } else {
//                    if (j <= 2) {
//                        board[i][j] = " 2 ";
//                    } else if (j >= 5) {
//                        board[i][j] = " 1 ";
//                    } else {
//                        board[i][j] = "   ";
//                    }
//                }
//            }
//        }

//        Тестовое заполнение.

        for (int j = 0; j <= 7; j++) {
            for (int i = 0; i <= 7; i++) {
                if ((i + j + 1) % 2 != 0) {
                    board[i][j] = " X ";
                } else {
                    if (j <= 2) {
                        board[i][j] = " T ";
                    } else if (j >= 5) {
                        board[i][j] = " O ";
                    } else {
                        board[i][j] = "   ";
                    }
                }
            }
        }
        for (int j = 0; j <= 7; j++) {
            for (int i = 0; i <= 7; i++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        Checkers.action();
    }

    public static void action() {
        Scanner console;
        while (true) {

            console = new Scanner(System.in);

            int select = console.nextInt();
            int move = console.nextInt();

            if (move / 10 > board.length - 1 && move % 10 > board.length - 1){
                System.out.println("Error in move");
                Checkers.action();
            }

            if (select / 10 <= board.length - 1 && select % 10 <= board.length - 1 &&
                    (board[select / 10][select % 10].equals(actingFigure))){
                    if (actingFigure.equals(" 1 ")){
                        System.out.println("One");
                        Checkers.One(select, move);
                        if (board[select / 10][select % 10].equals("   ") && move % 10 == 0){
                            board[move / 10][move % 10] = " O ";
                        }
                    }
                    else if (actingFigure.equals(" 2 ")){
                        System.out.println("Two");
                        Checkers.Two(select, move);
                        if (board[select / 10][select % 10].equals("   ") && move % 10 == 7){
                            board[move / 10][move % 10] = " T ";
                        }
                    }
                    else {
                        System.out.println("Error in select");
                        Checkers.action();
                    }
                }
            if (select / 10 <= board.length - 1 && select % 10 <= board.length - 1 &&
                    (board[select / 10][select % 10].equals(kingActingFigure))){
                if (kingActingFigure.equals(" O ")){
                    System.out.println("OneKing");
                    Checkers.figureO(select, move);
                }
                else if (actingFigure.equals(" T ")){
                    System.out.println("TwoKing");
                    Checkers.figureT(select, move);
                }
            }
            for (int j = 0; j <= 7; j++) {
                for (int i = 0; i <= 7; i++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
            Checkers.action();
        }
    }
    public static void One(int select, int move){

        int i = select / 10;
        int j = select % 10;

        if ((move == (i - 1) * 10 + (j - 1) || move == (i + 1) * 10 + (j - 1)) &&
                board[move / 10][move % 10].equals("   ")){
            System.out.println("Всё очень плохо №1");
            board[select / 10][select % 10] = "   ";
            board[move / 10][move % 10] = actingFigure;
            actingFigure = " 2 ";
            kingActingFigure = " T ";
        }
//        Метод поедания фигур одинаков как для №1, так и для №2. Это можно реализовать в отдельном методе, но потом.
//        Поправка. Из-за дамок алгоритм изменился. Но идею объединения стоит обдумать.
        else if((move == (i - 2) * 10 + (j + 2) || move == (i + 2) * 10 + (j + 2) ||
                move == (i - 2) * 10 + (j - 2) || move == (i + 2) * 10 + (j - 2)) &&
                (board[move / 10][move % 10].equals("   "))){
            board[select / 10][select % 10] = "   ";
            board[move / 10][move % 10] = actingFigure;
            if (select - move == -18){
                board[(move - 9) / 10][(move - 9) % 10] = "   ";
            }
            else if (select - move == -22){
                board[(move - 11) / 10][(move - 11) % 10] = "   ";
            }
            else if (select - move == 22){
                board[(move + 11) / 10][(move + 11) % 10] = "   ";
            }
            else if (select - move == 18){
                board[(move + 9) / 10][(move + 9) % 10] = "   ";
            }
        }
//        Конец метода поедания для №1
    }
    public static void Two(int select, int move){
        int i = select / 10;
        int j = select % 10;

        if ((move == (i - 1) * 10 + (j + 1) || move == (i + 1) * 10 + (j + 1)) &&
                board[move / 10][move % 10].equals("   ")){
            System.out.println("Всё очень плохо №2");
            board[select / 10][select % 10] = "   ";
            board[move / 10][move % 10] = actingFigure;
            actingFigure = " 1 ";
            kingActingFigure = " O ";
        }
//        Начало метода поедания для №2
        else if((move == (i - 2) * 10 + (j + 2) || move == (i + 2) * 10 + (j + 2) ||
                move == (i - 2) * 10 + (j - 2) || move == (i + 2) * 10 + (j - 2)) &&
                (board[move / 10][move % 10].equals("   "))){
            board[select / 10][select % 10] = "   ";
            board[move / 10][move % 10] = actingFigure;
            if (select - move == -18){
                board[(move - 9) / 10][(move - 9) % 10] = "   ";
            }
            else if (select - move == -22){
                board[(move - 11) / 10][(move - 11) % 10] = "   ";
            }
            else if (select - move == 22){
                board[(move + 11) / 10][(move + 11) % 10] = "   ";
            }
            else if (select - move == 18){
                board[(move + 9) / 10][(move + 9) % 10] = "   ";
            }
        }
//        Конец метода поедания для №2
    }
    public static void figureO (int select, int move){
        if (((select - move) % 11 == 0 || (select - move) % 9 == 0) && board[move / 10][move % 10].equals("   ")){

            int buffMove = move;
            int buffSM;
            boolean escalate = true;

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
                if (board[buffMove/10][buffMove%10].equals("   ")){
                    buffMove = buffMove + buffSM;
                }
                else if (board[buffMove/10][buffMove%10].equals(kingActingFigure) ||
                        board[buffMove/10][buffMove%10].equals(actingFigure)){
                    escalate = false;
                }
                else if (board[buffMove/10][buffMove%10].equals(" 2 ") ||
                        board[buffMove/10][buffMove%10].equals(" T ")){
                    buffMove = buffMove + buffSM;
                    if (board[buffMove/10][buffMove%10].equals("   ")){
                        board[(buffMove - buffSM)/10][(buffMove - buffSM)%10] = "   ";
                        board[buffMove/10][buffMove%10] = " O ";
                        board[select / 10][select % 10] = "   ";
                    }
                    else {
                        escalate = false;
                    }
                }
            }
            if (escalate){
                board[move / 10][move % 10] = kingActingFigure;
                board[select / 10][select % 10] = "   ";
            }
        }
        else {
            System.out.println("Error in select KO");
        }
    }
    public static void figureT (int select, int move){
        if (((select - move) % 11 == 0 || (select - move) % 9 == 0)  && board[move / 10][move % 10].equals("   ")){

            int buffMove = move;
            int buffSM = 0;
            boolean escalate = true;

            if ((select - move) % 11 == 0 && select - move < 0){
                buffSM = -11;
            }
            else if ((select - move) % 11 == 0 && select - move > 0){
                buffSM = 11;
            }
            else if ((select - move) % 9 == 0 && select - move > 0){
                buffSM = 9;
            }
            else if ((select - move) % 9 == 0 && select - move < 0){
                buffSM = -9;
            }

            while (buffMove != select && escalate){
                if (board[buffMove/10][buffMove%10].equals("   ")){
                    buffMove = buffMove + buffSM;
                }
                else if (board[buffMove/10][buffMove%10].equals(kingActingFigure) ||
                        board[buffMove/10][buffMove%10].equals(actingFigure)){
                    escalate = false;
                }
                else if (board[buffMove/10][buffMove%10].equals(" 1 ") ||
                        board[buffMove/10][buffMove%10].equals(" O ")){
                    buffMove = buffMove + buffSM;
                    if (board[buffMove/10][buffMove%10].equals("   ")){
                        board[(buffMove - buffSM)/10][(buffMove - buffSM)%10] = "   ";
                        board[buffMove/10][buffMove%10] = " T ";
                        board[select / 10][select % 10] = "   ";
                    }
                    else {
                        escalate = false;
                    }
                }
            }
            if (escalate){
                board[move / 10][move % 10] = kingActingFigure;
                board[select / 10][select % 10] = "   ";
            }
        }
        else {
            System.out.println("Error in select KT");
        }
    }
}
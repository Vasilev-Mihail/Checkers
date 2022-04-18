package com.game;

import java.util.Scanner;


public class Checkers {

    public static int [][]  board = new int[8][8];
    public static int actingFigure = 1;
    public static int actingKingFigure;

    public  void checkersBoard() {

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

        arbitrator();
    }

    public void actionSelect(boolean flag){
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
        actionMove(select, flag);
    }

    public void actionMove(int select, boolean flag) {
        System.out.println(flag);
        Scanner console;
        while (true) {

            console = new Scanner(System.in);

            int move = console.nextInt();
            actingKingFigure = actingFigure + 2;

            if (select / 10 > board.length - 1 || select % 10 > board.length - 1 ||
                    board[select / 10][select % 10] == 5 || board[select / 10][select % 10] == 0){
                System.out.println("Error in select");
                arbitrator();
            }
            else if (move / 10 > board.length - 1 || move % 10 > board.length - 1 || board[move / 10][move % 10] == 5){
                System.out.println("Error in move");
                actionMove(select, flag);
            }
            else if (board[select / 10][select % 10] == actingFigure ||
                    board[select / 10][select % 10] == actingKingFigure){
                if (board[select / 10][select % 10] > 2){
                    figureO(select, move, flag);
                }
                else {
                    One(select, move, flag);
                }
            }
            else {
                System.out.println(" Error target ");
                arbitrator();
            }
        }
    }

    public void One(int select, int move, boolean flag){

        int i = select / 10;
        int j = select % 10;

        if ((move == (i - 1) * 10 + (j - 1) || move == (i + 1) * 10 + (j - 1)) &&
                board[move / 10][move % 10] == 0 && !flag){
            System.out.println("Всё очень плохо №1");
            board[move / 10][move % 10] = board[select / 10][select % 10];
            board[select / 10][select % 10] = 0;
            if (actingFigure == 1){
                actingFigure += 1;
            }
            else actingFigure -= 1;
            arbitrator();
        }
        else if ((move == (i - 1) * 10 + (j + 1) || move == (i + 1) * 10 + (j + 1)) &&
                board[move / 10][move % 10] == 0 && !flag){
            System.out.println("Всё очень плохо №2");
            board[move / 10][move % 10] = board[select / 10][select % 10];
            board[select / 10][select % 10] = 0;
            if (actingFigure == 1){
                actingFigure += 1;
            }
            else {
                actingFigure -= 1;
            }
            actingKingFigure = actingFigure + 2;
            arbitrator();
        }
        else if((move == (i - 2) * 10 + (j + 2) || move == (i + 2) * 10 + (j + 2) ||
                move == (i - 2) * 10 + (j - 2) || move == (i + 2) * 10 + (j - 2)) &&
                (board[move / 10][move % 10] == 0)){
            if (move - select == -18 && ((board[(move - 9) / 10][(move - 9) % 10] != actingFigure ||
                    board[(move - 9) / 10][(move - 9) % 10] != actingKingFigure) &&
                    board[(move - 9) / 10][(move - 9) % 10] != 0)){
                board[(move - 9) / 10][(move - 9) % 10] = 0;
                board[move / 10][move % 10] = board[select / 10][select % 10];
                board[select / 10][select % 10] = 0;
                nextMove(move, false);
            }
            else if (move - select == -22 && (board[(move - 11) / 10][(move - 11) % 10] != actingFigure ||
                    board[(move - 11) / 10][(move - 11) % 10] != actingKingFigure) &&
                    board[(move - 11) / 10][(move - 11) % 10] != 0){
                board[(move - 11) / 10][(move - 11) % 10] = 0;
                board[move / 10][move % 10] = board[select / 10][select % 10];
                board[select / 10][select % 10] = 0;
                nextMove(move, false);
            }
            else if (move - select == 22 && (board[(move + 11) / 10][(move + 11) % 10] != actingFigure ||
                    board[(move + 11) / 10][(move + 11) % 10] != actingKingFigure) &&
                    board[(move + 11) / 10][(move + 11) % 10] != 0){
                board[(move + 11) / 10][(move + 11) % 10] = 0;
                board[move / 10][move % 10] = board[select / 10][select % 10];
                board[select / 10][select % 10] = 0;
                nextMove(move, false);
            }
            else if (move - select == 18 && (board[(move + 9) / 10][(move + 9) % 10] != actingFigure ||
                    board[(move + 9) / 10][(move + 9) % 10] != actingKingFigure) &&
                    board[(move + 9) / 10][(move + 9) % 10] != 0){
                board[(move + 9) / 10][(move + 9) % 10] = 0;
                board[move / 10][move % 10] = board[select / 10][select % 10];
                board[select / 10][select % 10] = 0;
                nextMove(move, false);
            }
            else {
                System.out.println("FF");
            }
        }
        else {
            System.out.println(" Final Error ");
//            arbitrator();
            actionMove(select, flag);
        }
    }
    public void figureO (int select, int move, boolean flag){
        if (((move - select) % 11 == 0 || (move - select) % 9 == 0) && board[move / 10][move % 10] == 0){

            int buffSelect = select;
            int buffSM;
            int buffShitAgan = board[select / 10][select % 10];
            boolean escalate = true;
            boolean target = false;

            if ((move - select) % 11 == 0 && move - select < 0){
                buffSM = -11;
            }
            else if ((move - select) % 11 == 0 && move - select > 0){
                buffSM = 11;
            }
            else if ((move - select) % 9 == 0 && move - select > 0){
                buffSM = 9;
            }
            else {
                buffSM = -9;
            }

            while (buffSelect != move && escalate){
                if (board[(buffSelect + buffSM) / 10][(buffSelect + buffSM) % 10] == 0){
                    buffSelect = buffSelect + buffSM;
                }
                else if (board[(buffSelect + buffSM) / 10][(buffSelect + buffSM) % 10] == actingFigure ||
                        board[(buffSelect + buffSM) / 10][(buffSelect + buffSM) % 10] == actingKingFigure){
                    escalate = false;
                }
                else if (board[(buffSelect + buffSM) / 10][(buffSelect + buffSM) % 10] != actingFigure ||
                        board[(buffSelect + buffSM) / 10][(buffSelect + buffSM) % 10] != actingKingFigure){
                    buffSelect = buffSelect + (2 * buffSM);
                    if (board[buffSelect / 10][buffSelect % 10] == 0){
//                        Место внедрения.
                        board[select / 10][select % 10] = 0;
                        target = true;
                    }
                    else {
                        escalate = false;
                    }
                }
            }
            if (flag && !target){
                escalate = false;
            }
            if (escalate){
                buffSelect = select;
                while (buffSelect != move){
                    if ((board[(buffSelect + buffSM) / 10][(buffSelect + buffSM) % 10] != actingFigure ||
                            board[(buffSelect + buffSM) / 10][(buffSelect + buffSM) % 10] != actingKingFigure) &&
                            board[(buffSelect + buffSM) / 10][(buffSelect + buffSM) % 10] != 0) {
                        buffSelect = buffSelect + (2 * buffSM);
                        if (board[buffSelect / 10][buffSelect % 10] == 0) {
                            board[(buffSelect - buffSM) / 10][(buffSelect - buffSM) % 10] = 0;
                            board[buffSelect / 10][buffSelect % 10] = board[select / 10][select % 10];
                            board[select / 10][select % 10] = 0;
                            target = true;
                        }
                    }
                    else {
                        buffSelect = buffSelect + buffSM;
                    }
                }
                board[move / 10][move % 10] = buffShitAgan;
                board[select / 10][select % 10] = 0;
                if (target){
                    nextMoveKing(move, false);
                }
                else if (actingFigure == 1){
                    actingFigure += 1;
                    actingKingFigure = actingFigure + 2;
                    arbitrator();
                }
                else {
                    actingFigure -= 1;
                    actingKingFigure = actingFigure + 2;
                    arbitrator();
                }
            }
            else {
                System.out.println("Error in KF");
                arbitrator();
            }
        }
        else {
            System.out.println(" Error in SK or MK");
            arbitrator();
        }
    }
    public void nextMove(int move, boolean check){

        boolean indicator = false;
        if (move / 10 < 6 && move % 10 > 1 && (board[(move + 9) / 10][(move + 9) % 10] != actingFigure &&
                board[(move + 9) / 10][(move + 9) % 10] != 0 &&
                board[(move + 9) / 10][(move + 9) % 10] != actingKingFigure &&
                board[(move + 18) / 10][(move + 18) % 10] == 0)){
            indicator = true;
        }
        else if (move / 10 > 1 && move % 10 > 1 && (board[(move - 11) / 10][(move - 11) % 10] != actingFigure &&
                board[(move - 11) / 10][(move - 11) % 10] != 0 &&
                board[(move - 11) / 10][(move - 11) % 10] != actingKingFigure &&
                board[(move - 22) / 10][(move - 22) % 10] == 0)){
            indicator = true;
        }
        else if (move / 10 < 6 && move % 10 < 6 && (board[(move + 11) / 10][(move + 11) % 10] != actingFigure &&
                board[(move + 11) / 10][(move + 11) % 10] != 0 &&
                board[(move + 11) / 10][(move + 11) % 10] != actingKingFigure &&
                board[(move + 22) / 10][(move + 22) % 10] == 0)){
            indicator = true;
        }
        else if (move / 10 > 1 && move % 10 < 6 && (board[(move - 9) / 10][(move - 9) % 10] != actingFigure &&
                board[(move - 9) / 10][(move - 9) % 10] != 0 &&
                board[(move - 9) / 10][(move - 9) % 10] != actingKingFigure &&
                board[(move - 18) / 10][(move - 18) % 10] == 0)){
            indicator = true;
        }
        if (indicator && check){
            actionSelect(true);
        }
        else if (indicator){
            actionMove(move, true);
        }
        else if (actingFigure == 1 && !check){
            actingFigure += 1;
            actingKingFigure = actingFigure + 2;
            arbitrator();
        }
        else if (!check){
            actingFigure -= 1;
            actingKingFigure = actingFigure + 2;
            arbitrator();
        }
    }

    public void nextMoveKing(int move, boolean check){
        System.out.println(" Проверка " + actingFigure);
        int buff = move;
        boolean escalate = false;
        boolean target = false;

        while (buff / 10 < 6 && buff % 10 > 1 && !escalate){
            if (board[(buff + 9) / 10][(buff + 9) % 10] != actingFigure &&
                    board[(buff + 9) / 10][(buff + 9) % 10] != 0 &&
                    board[(buff + 9) / 10][(buff + 9) % 10] != actingKingFigure &&
                    board[(buff + 18) / 10][(buff + 18) % 10] == 0){
                target = true;
                escalate = true;
            }
            else if (board[(buff + 9) / 10][(buff + 9) % 10] == 0){
                buff = buff + 9;
            }
            else escalate = true;

        }
        buff = move;
        escalate = false;
        while (buff / 10 > 1 && buff % 10 > 1 && !escalate){
            if (board[(buff - 11) / 10][(buff - 11) % 10] != actingFigure &&
                    board[(buff - 11) / 10][(buff - 11) % 10] != 0 &&
                    board[(buff - 11) / 10][(buff - 11) % 10] != actingKingFigure &&
                    board[(buff - 22) / 10][(buff - 22) % 10] == 0){
                target = true;
                escalate = true;
            }
            else if (board[(buff - 11) / 10][(buff - 11) % 10] == 0){
                buff = buff - 11;
            }
            else escalate = true;

        }
        buff = move;
        escalate = false;
        while (buff / 10 < 6 && buff % 10 < 6 && !escalate){
            if (board[(buff + 11) / 10][(buff + 11) % 10] != actingFigure &&
                    board[(buff + 11) / 10][(buff + 11) % 10] != 0 &&
                    board[(buff + 11) / 10][(buff + 11) % 10] != actingKingFigure &&
                    board[(buff + 22) / 10][(buff + 22) % 10] == 0){
                target = true;
                escalate = true;
            }
            else if (board[(buff + 11) / 10][(buff + 11) % 10] == 0){
                buff = buff + 11;
            }
            else escalate = true;

        }
        buff = move;
        escalate = false;
        while (buff / 10 > 1 && buff % 10 < 6 && !escalate){
            if (board[(buff - 9) / 10][(buff - 9) % 10] != actingFigure &&
                    board[(buff - 9) / 10][(buff - 9) % 10] != 0 &&
                    board[(buff - 9) / 10][(buff - 9) % 10] != actingKingFigure &&
                    board[(buff - 18) / 10][(buff - 18) % 10] == 0){
                target = true;
                escalate = true;
            }
            else if (board[(buff - 9) / 10][(buff - 9) % 10] == 0){
                buff = buff - 9;
            }
            else escalate = true;

        }
        if(target && !check){
            actionMove(move, true);
        }
        else if (target){
            actionSelect(true);
//            Место внедрения.
        }
        else if (actingFigure == 1 && !check){
                actingFigure += 1;
                actingKingFigure = actingFigure + 2;
                arbitrator();
            }
        else if(!check){
            actingFigure -= 1;
            actingKingFigure = actingFigure + 2;
            arbitrator();
        }
    }
    public void arbitrator(){
        System.out.println(" Актив " + actingFigure);
        for (int j = 0; j <= 7; j++) {
            for (int i = 0; i <= 7; i++) {
                if (board[i][j] == actingFigure){
                    nextMove(((i * 10) + j), true);
                }
                else if (board[i][j] == actingKingFigure){
                    nextMoveKing(((i * 10) + j), true);
                }
            }
        }
        actionSelect(false);
    }
}

package com.refactor;

public class CheckersFigure {

    public void checkersFigure(int select, int move, boolean flag){

        int i = select / 10;
        int j = select % 10;

        if ((move == (i - 1) * 10 + (j - 1) || move == (i + 1) * 10 + (j - 1)) &&
                Main.board[move / 10][move % 10] == 0 && !flag){
            Main.board[move / 10][move % 10] = Main.board[select / 10][select % 10];
            Main.board[select / 10][select % 10] = 0;
            if (Main.actingFigure == 1){
                Main.actingFigure += 1;
            }
            else Main.actingFigure -= 1;
            Arbitrator arbitratorObject = new Arbitrator();
            arbitratorObject.arbitrator();
        }
        else if ((move == (i - 1) * 10 + (j + 1) || move == (i + 1) * 10 + (j + 1)) &&
                Main.board[move / 10][move % 10] == 0 && !flag){
            Main.board[move / 10][move % 10] = Main.board[select / 10][select % 10];
            Main.board[select / 10][select % 10] = 0;
            if (Main.actingFigure == 1){
                Main.actingFigure += 1;
            }
            else {
                Main.actingFigure -= 1;
            }
            Arbitrator arbitratorObject = new Arbitrator();
            arbitratorObject.arbitrator();
        }
        else if((move == (i - 2) * 10 + (j + 2) || move == (i + 2) * 10 + (j + 2) ||
                move == (i - 2) * 10 + (j - 2) || move == (i + 2) * 10 + (j - 2)) &&
                (Main.board[move / 10][move % 10] == 0)){
            if (move - select == -18 && ((Main.board[(move - 9) / 10][(move - 9) % 10] != Main.actingFigure ||
                    Main.board[(move - 9) / 10][(move - 9) % 10] != Main.actingFigure + 2) &&
                    Main.board[(move - 9) / 10][(move - 9) % 10] != 0)){
                Main.board[(move - 9) / 10][(move - 9) % 10] = 0;
                Main.board[move / 10][move % 10] = Main.board[select / 10][select % 10];
                Main.board[select / 10][select % 10] = 0;
                NextMove nextMoveObject = new NextMove();
                nextMoveObject.nextMove(move, false);
            }
            else if (move - select == -22 && (Main.board[(move - 11) / 10][(move - 11) % 10] != Main.actingFigure ||
                    Main.board[(move - 11) / 10][(move - 11) % 10] != Main.actingFigure + 2) &&
                    Main.board[(move - 11) / 10][(move - 11) % 10] != 0){
                Main.board[(move - 11) / 10][(move - 11) % 10] = 0;
                Main.board[move / 10][move % 10] = Main.board[select / 10][select % 10];
                Main.board[select / 10][select % 10] = 0;
                NextMove nextMoveObject = new NextMove();
                nextMoveObject.nextMove(move, false);
            }
            else if (move - select == 22 && (Main.board[(move + 11) / 10][(move + 11) % 10] != Main.actingFigure ||
                    Main.board[(move + 11) / 10][(move + 11) % 10] != Main.actingFigure + 2) &&
                    Main.board[(move + 11) / 10][(move + 11) % 10] != 0){
                Main.board[(move + 11) / 10][(move + 11) % 10] = 0;
                Main.board[move / 10][move % 10] = Main.board[select / 10][select % 10];
                Main.board[select / 10][select % 10] = 0;
                NextMove nextMoveObject = new NextMove();
                nextMoveObject.nextMove(move, false);
            }
            else if (move - select == 18 && (Main.board[(move + 9) / 10][(move + 9) % 10] != Main.actingFigure ||
                    Main.board[(move + 9) / 10][(move + 9) % 10] != Main.actingFigure + 2) &&
                    Main.board[(move + 9) / 10][(move + 9) % 10] != 0){
                Main.board[(move + 9) / 10][(move + 9) % 10] = 0;
                Main.board[move / 10][move % 10] = Main.board[select / 10][select % 10];
                Main.board[select / 10][select % 10] = 0;
                NextMove nextMoveObject = new NextMove();
                nextMoveObject.nextMove(move, false);
            }
            else {
                System.out.println("FF");
            }
        }
        else {
            System.out.println(" Final Error ");
            ActionMove actionMoveObject = new ActionMove();
            actionMoveObject.actionMove(select, flag);
        }
    }
}

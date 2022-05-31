package com.refactor;

public class NextMove {

    public void nextMove(int move, boolean check){

        boolean indicator = false;
        if (move / 10 < 6 && move % 10 > 1 && (Main.board[(move + 9) / 10][(move + 9) % 10] != Main.actingFigure &&
                Main.board[(move + 9) / 10][(move + 9) % 10] != 0 &&
                Main.board[(move + 9) / 10][(move + 9) % 10] != Main.actingFigure + 2 &&
                Main.board[(move + 18) / 10][(move + 18) % 10] == 0)){
            indicator = true;
        }
        else if (move / 10 > 1 && move % 10 > 1 && (Main.board[(move - 11) / 10][(move - 11) % 10] != Main.actingFigure &&
                Main.board[(move - 11) / 10][(move - 11) % 10] != 0 &&
                Main.board[(move - 11) / 10][(move - 11) % 10] != Main.actingFigure + 2 &&
                Main.board[(move - 22) / 10][(move - 22) % 10] == 0)){
            indicator = true;
        }
        else if (move / 10 < 6 && move % 10 < 6 && (Main.board[(move + 11) / 10][(move + 11) % 10] != Main.actingFigure &&
                Main.board[(move + 11) / 10][(move + 11) % 10] != 0 &&
                Main.board[(move + 11) / 10][(move + 11) % 10] != Main.actingFigure + 2 &&
                Main.board[(move + 22) / 10][(move + 22) % 10] == 0)){
            indicator = true;
        }
        else if (move / 10 > 1 && move % 10 < 6 && (Main.board[(move - 9) / 10][(move - 9) % 10] != Main.actingFigure &&
                Main.board[(move - 9) / 10][(move - 9) % 10] != 0 &&
                Main.board[(move - 9) / 10][(move - 9) % 10] != Main.actingFigure + 2 &&
                Main.board[(move - 18) / 10][(move - 18) % 10] == 0)){
            indicator = true;
        }
        if (indicator && check){
            ActionSelect actionSelectObject = new ActionSelect();
            actionSelectObject.actionSelect(true);
        }
        else if (indicator){
            ActionMove actionMoveObject = new ActionMove();
            actionMoveObject.actionMove(move, true);
        }
        else if (Main.actingFigure == 1 && !check){
            Main.actingFigure += 1;

            Arbitrator arbitratorObject = new Arbitrator();
            arbitratorObject.arbitrator();
        }
        else if (!check){
            Main.actingFigure -= 1;

            Arbitrator arbitratorObject = new Arbitrator();
            arbitratorObject.arbitrator();
        }
    }
}

package com.refactor;

import static com.refactor.Main.actingFigure;
import static com.refactor.Main.board;

public class NextMoveKing {

    public void nextMoveKing(int move, boolean check, int targetBuff, boolean kingRule){
        int buff = move;
        boolean escalate = false;
        boolean target = false;

        while (buff / 10 < 6 && buff % 10 > 1 && !escalate){
            if (board[(buff + 9) / 10][(buff + 9) % 10] != actingFigure &&
                    board[(buff + 9) / 10][(buff + 9) % 10] != 0 &&
                    board[(buff + 9) / 10][(buff + 9) % 10] != actingFigure + 2 &&
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
                    board[(buff - 11) / 10][(buff - 11) % 10] != actingFigure + 2 &&
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
                    board[(buff + 11) / 10][(buff + 11) % 10] != actingFigure + 2 &&
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
                    board[(buff - 9) / 10][(buff - 9) % 10] != actingFigure + 2 &&
                    board[(buff - 18) / 10][(buff - 18) % 10] == 0){
                target = true;
                escalate = true;
            }
            else if (board[(buff - 9) / 10][(buff - 9) % 10] == 0){
                buff = buff - 9;
            }
            else escalate = true;

        }
        if(target && !check && !kingRule){
            ActionMove actionMoveObject = new ActionMove();
            actionMoveObject.actionMove(move, true);
        }
        else if (!target && !check && !kingRule){
            KingRules kingRulesObject = new KingRules();
            kingRulesObject.kingRules(targetBuff, move);
        }
        else if (target && !kingRule){
            ActionSelect actionSelectObject = new ActionSelect();
            actionSelectObject.actionSelect(true);
        }
        else if (target){
            board[move / 10][move % 10] = actingFigure + 2;
            ActionMove actionMoveObject = new ActionMove();
            actionMoveObject.actionMove(move, true);
        }
    }
}

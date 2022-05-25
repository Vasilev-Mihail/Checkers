package com.refactor;

import static com.refactor.Main.actingFigure;
import static com.refactor.Main.board;

public class KingRules {

    public void kingRules(int targetBuff, int move){

        int buffMove = move;
        int buffSM;

        board[move / 10][move % 10] = 0;

        if ((move - targetBuff) % 11 == 0 && move - targetBuff < 0){
            buffSM = -11;
        }
        else if ((move - targetBuff) % 11 == 0 && move - targetBuff > 0){
            buffSM = 11;
        }
        else if ((move - targetBuff) % 9 == 0 && move - targetBuff > 0){
            buffSM = 9;
        }
        else {
            buffSM = -9;
        }

        while (buffMove != targetBuff + buffSM && board[(buffMove - buffSM) / 10][(buffMove - buffSM) % 10] == 0){
            buffMove = buffMove - buffSM;
            NextMoveKing nextMoveKingObject = new NextMoveKing();
            nextMoveKingObject.nextMoveKing(buffMove, true, targetBuff, true);
        }
        buffMove = move;
        while (buffMove + buffSM >= 0 && (buffMove + buffSM) / 10 <= board.length - 1 &&
                (buffMove + buffSM) % 10 <= board.length - 1 &&
                board[(buffMove + buffSM) / 10][(buffMove + buffSM) % 10] == 0){
            buffMove = buffMove + buffSM;
            NextMoveKing nextMoveKingObject = new NextMoveKing();
            nextMoveKingObject.nextMoveKing(buffMove, true, targetBuff, true);
        }
        board[move / 10][move % 10] = actingFigure + 2;
        if (actingFigure == 1){
            actingFigure += 1;
        }
        else{
            actingFigure -= 1;
        }
        Arbitrator arbitratorObject = new Arbitrator();
        arbitratorObject.arbitrator();
    }
}

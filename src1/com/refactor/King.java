package com.refactor;

public class King {

    public void king (int select, int move, boolean flag){
        if (((move - select) % 11 == 0 || (move - select) % 9 == 0) && Main.board[move / 10][move % 10] == 0){

            int targetBuff = 88;
            int buffSelect = select;
            int buffSM;
            int buffShitAgan = Main.board[select / 10][select % 10];
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
                if (Main.board[(buffSelect + buffSM) / 10][(buffSelect + buffSM) % 10] == 0){
                    buffSelect = buffSelect + buffSM;
                }
                else if (Main.board[(buffSelect + buffSM) / 10][(buffSelect + buffSM) % 10] == Main.actingFigure ||
                        Main.board[(buffSelect + buffSM) / 10][(buffSelect + buffSM) % 10] == Main.actingFigure + 2){
                    escalate = false;
                }
                else if (Main.board[(buffSelect + buffSM) / 10][(buffSelect + buffSM) % 10] != Main.actingFigure ||
                        Main.board[(buffSelect + buffSM) / 10][(buffSelect + buffSM) % 10] != Main.actingFigure + 2){
                    buffSelect = buffSelect + (2 * buffSM);
                    if (Main.board[buffSelect / 10][buffSelect % 10] == 0){
                        Main.board[select / 10][select % 10] = 0;
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
                    if ((Main.board[(buffSelect + buffSM) / 10][(buffSelect + buffSM) % 10] != Main.actingFigure ||
                            Main.board[(buffSelect + buffSM) / 10][(buffSelect + buffSM) % 10] != Main.actingFigure + 2) &&
                            Main.board[(buffSelect + buffSM) / 10][(buffSelect + buffSM) % 10] != 0) {
                        buffSelect = buffSelect + (2 * buffSM);
                        if (Main.board[buffSelect / 10][buffSelect % 10] == 0) {
                            Main.board[(buffSelect - buffSM) / 10][(buffSelect - buffSM) % 10] = 0;
                            Main.board[buffSelect / 10][buffSelect % 10] = Main.board[select / 10][select % 10];
                            Main.board[select / 10][select % 10] = 0;
                            target = true;
                            targetBuff = buffSelect - buffSM;
                        }
                    }
                    else {
                        buffSelect = buffSelect + buffSM;
                    }
                }
                Main.board[move / 10][move % 10] = buffShitAgan;
                Main.board[select / 10][select % 10] = 0;
                if (target){
                    NextMoveKing nextMoveKingObject = new NextMoveKing();
                    nextMoveKingObject.nextMoveKing(move, false, targetBuff, false);
                }
                else if (Main.actingFigure == 1){
                    Main.actingFigure += 1;
                    Arbitrator arbitratorObject = new Arbitrator();
                    arbitratorObject.arbitrator();
                }
                else {
                    Main.actingFigure -= 1;
                    Arbitrator arbitratorObject = new Arbitrator();
                    arbitratorObject.arbitrator();
                }
            }
            else {
                System.out.println("Error in KF");
                Arbitrator arbitratorObject = new Arbitrator();
                arbitratorObject.arbitrator();
            }
        }
        else {
            System.out.println(" Error in SK or MK");
            Arbitrator arbitratorObject = new Arbitrator();
            arbitratorObject.arbitrator();
        }
    }
}

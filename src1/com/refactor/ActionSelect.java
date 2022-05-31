package com.refactor;

import java.util.Scanner;

public class ActionSelect {

    public void actionSelect(boolean flag){
        Scanner console;
        console = new Scanner(System.in);

        for (int j = 0; j <= 7; j++) {
            for (int i = 0; i <= 7; i++) {
                if (j == 7 && Main.board[i][j] == 2){
                    Main.board[i][j] = 4;
                }
                else if(j == 0 && Main.board[i][j] == 1){
                    Main.board[i][j] = 3;
                }
                System.out.print(Main.board[i][j]);
            }
            System.out.println();
        }

        int select = console.nextInt();
        ActionMove actionMoveObject = new ActionMove();
        actionMoveObject.actionMove(select, flag);
    }
}

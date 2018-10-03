package com.company;

import java.util.Scanner;

public class Player {
    private final char player;

    public Player() {
        player = setPlayer();
    }

    public char setPlayer() {
        System.out.println("Enter your nickname X or O:");
        Scanner num = new Scanner(System.in);
        char player = num.next().charAt(0);
        if (player == 'X' || player == 'O') return player;
        else return setPlayer();
    }

    public char getPlayer() {
        return player;
    }

    public int getPosition(Playground playground) {
        System.out.println("Enter a position (1-" + (int) Math.pow(playground.getSize(), 2) + ") of X: ");
        Scanner num = new Scanner(System.in);
        return num.nextInt();
    }

    public void step(Playground playground) {

        int position = getPosition(playground);

        if (position <= 0 || position > (int) Math.pow(playground.getSize(), 2)) {
            System.out.println("No!!!");
            step(playground);
        }

        for (int i = 0; i < playground.getPlayground().length; i++) {
            for (int j = 0; j < playground.getPlayground().length; j++) {
                position--;
                if (position == 0) {
                    if (playground.getElement(i, j) != 'O' && playground.getElement(i, j) != 'X') {
                        playground.setElement(i, j, player);
                        break;
                    } else {
                        System.out.println("No!!!");
                        step(playground);
                    }
                }
            }
        }
    }
}

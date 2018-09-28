package com.company;

import java.util.Scanner;

public class Playground {

    private int size;

    private char[][] playground;

    public Playground() {
        size = setSize();
        playground = new char[size][size];
    }

    public int setSize() {
        System.out.println("Enter a size of playground: ");
        Scanner num = new Scanner(System.in);
        return num.nextInt();
    }

    public int getSize() {
        return size;
    }

    public void createPlayground() {
        for (int i = 1; i <= (size * size); i++) {
            if (i % size == 0) {
                System.out.println(i);
                if (i != size * size)
                    setBarrier();
            } else if (i < 10) System.out.print(i + " | ");
            else System.out.print(i + "| ");
        }
    }

    public void showPlayground() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (j % (size - 1) == 0 && j != 0) {
                    System.out.println(playground[i][j]);
                    if (i != size - 1) {
                        setBarrier();
                    }
                } else System.out.print(playground[i][j] + " | ");
            }
        }
    }

    public void setElement(int i, int j, char value) {
        playground[i][j] = value;
    }

    public char[][] getPlayground() {
        return playground;
    }

    public char getElement(int i, int j) {
        return playground[i][j];
    }

    public void setBarrier() {
        for (int n = 0; n < (size * 4 - 2); n++) {
            System.out.print("-");
        }
        System.out.print("\n");
    }

    public void checkVictoryDiagonally() {
        boolean victory = true;
        char play = playground[0][0];
        for (int i = 0; i < size; i++) {
            if (victory) {
                if (playground[i][i] != play) {
                    victory = false;
                    break;
                }
            }
        }
        if (victory && play != 0) {
            exitTheGame(play);
        }
        //----------------------------------------------------
        victory = true;
        play = playground[0][size - 1];
        for (int i = 0, j = size - 1; i < size && j >= 0; i++, j--) {
            if (victory) {
                if (playground[i][j] != play) {
                    victory = false;
                    break;
                }
            }
        }
        if (victory && play != 0) {
            exitTheGame(play);
        }
    }

    public void checkVictoryFromTopToDown() {
        boolean victory = true;
        char play;
        for (int i = 0; i < size; i++) {
            victory = true;
            play = playground[i][0];
            for (int j = 0; j < size; j++) {
                if (victory) {
                    if (playground[i][j] != play) {
                        victory = false;
                        break;
                    }
                }
            }
            if (victory && play != 0) {
                exitTheGame(play);
            }
        }
    }

    public void checkVictoryFromLeftToRight() {
        boolean victory = true;
        char play;
        for (int i = 0; i < size; i++) {
            victory = true;
            play = playground[0][i];
            for (int jindex = 0; jindex < size; jindex++) {
                if (victory) {
                    if (playground[jindex][i] != play) {
                        victory = false;
                        break;
                    }
                }
            }
            if (victory && play != 0) {
                exitTheGame(play);
            }
        }
    }

    public void exitTheGame(char play) {
        System.out.println("Winner " + play);
        System.exit(0);
    }

    public void checkVictory(Player player, Computer computer) {
        checkVictoryDiagonally();
        checkVictoryFromTopToDown();
        checkVictoryFromLeftToRight();
    }


}

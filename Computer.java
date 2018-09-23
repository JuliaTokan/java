package com.company;

public class Computer {

    private final char computer;

    public Computer(Player player) {
        computer = getComputer(player);
    }

    public char getComputer(Player player) {
        if (player.getPlayer() == 'X') return 'O';
        else return 'X';
    }

    public void step(Playground playground) {
        for (int i = 0, j = 0; ; ) {
            i = (int) (Math.random() * 3);
            j = (int) (Math.random() * 3);
            if (playground.getElement(i, j) != 'X' && playground.getElement(i, j) != 'O') {
                playground.setElement(i, j, computer);
                return;
            }
        }
    }

}

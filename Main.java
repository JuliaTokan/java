package com.company;

public class Main {

    public static void main(String[] args) {
        Playground playground = new Playground();
        Player player = new Player();
        Computer computer = new Computer(player);

        playground.createPlayground();

        for (int i = 0; i < (int) Math.ceil(Math.pow(playground.getSize(), 2) / 2); i++) {
            System.out.println();
            playground.showPlayground();
            player.step(playground);
            playground.showPlayground();
            playground.checkVictory(player, computer);
            computer.step(playground);
            playground.checkVictory(player, computer);
        }
        System.out.println("Dead heat!!!");
    }
}

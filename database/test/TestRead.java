package test;

import db.HumanDAO;
import human.Human;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class TestRead {
    public static void main(String[] args) {
        ArrayList<Human> humans = new ArrayList<Human>();

        File file = new File("/Users/yulia/Documents/test.txt");
        HumanDAO humanDAO = new HumanDAO(file);
        try {
            humans = humanDAO.read();
            printInform(humans);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printInform(ArrayList<Human> humans) {
        for (int i = 0; i < humans.size(); i++) {
            System.out.println("Human #" + (i + 1) + ":");
            System.out.println(humans.get(i).getName());
            System.out.println(humans.get(i).getSurName());
            System.out.println(humans.get(i).getDate());
            System.out.println(humans.get(i).getPosition());
            System.out.println(humans.get(i).getSalary() + "\n");
        }
    }
}

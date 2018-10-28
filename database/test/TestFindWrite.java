package test;

import db.HumanDAO;
import human.Human;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class TestFindWrite {
    public static void main(String[] args) {
        Human human1 = new Human("Mike", "Best", new Date(86, 1, 1), "Team Lead",
                1000);
        Human human2 = new Human("Yuli", "Tokan", new Date(99, 8, 23), "Junior",
                1000);
        Human human3 = new Human("Mike", "Best", new Date(86, 1, 1), "Team Lead",
                1000);
        Human human4 = new Human("Yuli", "Tokan", new Date(99, 8, 23), "Junior",
                500);
        Human human5 = new Human("Mike", "Best", new Date(86, 1, 1), "Team Lead",
                500);
        Human human6 = new Human("Yuli", "Tokan", new Date(99, 8, 23), "Junior",
                500);
        File file = new File("/Users/yulia/Documents/test.txt");
        HumanDAO humanDAO = new HumanDAO(file);
        try {
            humanDAO.write(human1);
            humanDAO.write(human2);
            humanDAO.write(human3);
            humanDAO.write(human4);
            humanDAO.write(human5);
            humanDAO.write(human6);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package test;

import db.HumanDAO;
import human.Human;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class TestWrite {
    public static void main(String[] args) {
        Human human1 = new Human("Mike", "Best", new Date(86, 1, 1), "Junior",
                1000);
        Human human2 = new Human("Yuli", "Tokan", new Date(99, 8, 23), "Team Lead",
                1000);
        File file = new File("/Users/yulia/Documents/test1.txt");
        HumanDAO humanDAO = new HumanDAO(file);
        try {
            humanDAO.write(human1);
            humanDAO.write(human2);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

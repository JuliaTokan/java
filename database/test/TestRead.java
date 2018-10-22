package test;

import db.HumanDAO;

import java.io.File;
import java.io.IOException;

public class TestRead {
    public static void main(String[] args) {
        File file = new File("/Users/yulia/Documents/test.txt");
        HumanDAO humanDAO = new HumanDAO(file);
        try {
            humanDAO.read();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

package test;

import db.HumanDAO;
import human.Human;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class TestFind {
    public static void main(String[] args) {
        ArrayList<Human> humans = new ArrayList<Human>();

        File file = new File("/Users/yulia/Documents/test.txt");
        HumanDAO humanDAO = new HumanDAO(file);
        try {
            humans = humanDAO.readFilterSurname("Tokan");
            System.out.println("Syrname: Tokan");
            printInform(humans);

            humans = humanDAO.readFilterNameAndSurname("Yuli", "Yokan");
            System.out.println("Name:Yuli Syrname: Tokan");
            printInform(humans);

            humans = humanDAO.readFilterBirthBefore(new Date(98, 10, 10));
            System.out.println("Birth before 1998.10.10");
            printInform(humans);

            humans = humanDAO.readFilterBirthAfter(new Date(98, 10, 10));
            System.out.println("Birth after 1998.10.10");
            printInform(humans);

            humans = humanDAO.readFilterBirthInDiapason(new Date(85, 3, 2), new Date(99, 7, 10));
            System.out.println("Birth 1985.10.10 - 1999.10.10");
            printInform(humans);

            humans = humanDAO.readFilterPosition("Junior");
            System.out.println("Position: Junior");
            printInform(humans);

            humans = humanDAO.readFilterSalaryMoreThan(600);
            System.out.println("Salary more than 600");
            printInform(humans);

            humans = humanDAO.readFilterSalaryLessThan(600);
            System.out.println("Salary less than 600");
            printInform(humans);

            humans = humanDAO.readFilterSalaryInDiapason(400, 600);
            System.out.println("Salary in diapason 400 - 600");
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

package Studentslist;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
	    Student student1 = new Student("Yulia", "Tokan",  new Date(1986, 1, 1));
        Student student2 = new Student("Masha", "Tokan",  new Date(1986, 1, 1));
        Student student3 = new Student("Yulia", "Tokan",  new Date(1984, 1, 1));
        Student student4 = new Student("Yulia", "Tokan",  new Date(1984, 1, 1));

        StudentsList studentsList = new StudentsList();
        studentsList.addMoreThan100(student1);
        studentsList.addMoreThan100(student2);
        studentsList.addMoreThan100(student3);
        studentsList.addMoreThan100(student4);

        Date date =  new Date(1986, 1, 1);

        int slist[] = studentsList.findStudentsBySurname("Tokan");

        for(int i = 0; i<slist.length; i++){
            System.out.println(slist[i]);
        }
    }
}

package Studentslist;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
	    Student student1 = new Student("Yulia", "Tokan",  new Date(1986, 1, 1));
        Student student2 = new Student("Masha", "Tokan",  new Date(1986, 1, 1));
        Student student3 = new Student("Yulia", "Tokan",  new Date(1984, 1, 1));
        Student student4 = new Student("Yulia", "Tokan",  new Date(1984, 1, 1));

        StudentsList studentsList = new StudentsList();
        studentsList.add(student1);
        studentsList.add(student2);
        studentsList.add(student3);
        studentsList.add(student4);

        Date date =  new Date(1986, 1, 1);

        int slist[] = studentsList.findStudentsBySurname("Tokan");

        for(int i:slist){
            System.out.println(slist[i]);
        }
    }
}

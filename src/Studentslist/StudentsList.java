package Studentslist;

import java.util.Date;
import java.util.Arrays;

public class StudentsList {
    private Student[] list = new Student[100];
    private int num = 0;

    public void add(Student s) {
        list[num] = s;
        num++;
    }

    public Student getStudent(int n) {
        return list[n];
    }

    public int getNum() {
        return num;
    }

    public int findStudentByName(String name) {
        for (int index = 0; index < num; index++) {
            if (list[index].getName().equalsIgnoreCase(name))
                return index;
        }
        return -1;
    }
    //---------------------------------------------------- Домашняя работа

    public int findStudentBySurname(String surname) {
        for(int index = 0; index < num; index++)
        {
            Student student = list[index];
            String studentSurname = student.getSurname();
            if(studentSurname.equalsIgnoreCase(surname))
                return index;
        }
        return -1;
    }

    public int findStudentByBirth(Date date) {
        for(int index = 0; index < num; index++)
        {
            Student student = list[index];
            Date studentBirth = student.getBirth();
            if(studentBirth.equals(date))
                return index;
        }
        return -1;
    }

    public int[] findStudentsByName(String name){
        int[] searchList = new int[num];
        int indexList = 0;
        for (int index = 1; index < num; index++) {
            Student student = list[index];
            String studentName = student.getName();
            System.out.println(studentName);
            if (studentName.equalsIgnoreCase(name)) {
                searchList[indexList] = index;
                indexList++;
            }
        }
        return Arrays.copyOfRange(searchList, 0, indexList);
    }

    public int[] findStudentsBySurname(String surname){
        int[] searchList = new int[num];
        int indexList = 0;
        for (int index = 0; index < num; index++) {
            Student student = getStudent(index);
            String studentSurname = student.getSurname();
            if (studentSurname.equalsIgnoreCase(surname)) {
                searchList[indexList] = index;
                indexList++;
            }
        }
        return Arrays.copyOfRange(searchList, 0, indexList);
    }

    public int[] findStudentsByBirth(Date date){
        int num = getNum();
        int[] searchList = new int[num];
        int indexList = 0;
        for (int index = 0; index < num; index++) {
            Student student = list[index];
            Date studentBirth = student.getBirth();
            if(studentBirth.equals(date)){
                searchList[indexList] = index;
                indexList++;
            }
        }
        return Arrays.copyOfRange(searchList, 0, indexList);
    }

    public void addMoreThan100(Student student) {
        if(num<3)
            add(student);
        else {
            Student[] studentsList = list.clone();
            list = new Student[num+1];
            System.arraycopy(studentsList, 0, list, 0, num);
            list[num] = student;
            num++;
        }
    }
}

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
        int num = getNum();
        int[] searchList = new int[num];
        int indexList = 0;
        for (int index = 0; index < num; index++) {
            Student student = list[index];
            String studentName = student.getName();
            if (studentName.equalsIgnoreCase(name)) {
                searchList[indexList] = index;
                indexList++;
            }
        }
        return Arrays.copyOfRange(searchList, 0, indexList);
    }
    public int[] findStudentsBySurname(String surname){
        int num = getNum();
        int[] searchList = new int[num];
        int indexList = 0;
        for (int index = 0; index < num; index++) {
            Student student = list[index];
            String studentName = student.getSurname();
            if (studentName.equalsIgnoreCase(surname)) {
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
}

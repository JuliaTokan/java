package human;

import java.util.Date;

public class Human {
    private String name;
    private String surName;
    private Date date;
    private String position;
    private double salary;

    public Human(String name, String surName, Date date, String position, double salary) {
        this.name = name;
        this.surName = surName;
        this.date = date;
        this.position = position;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public Date getDate() {
        return date;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


}

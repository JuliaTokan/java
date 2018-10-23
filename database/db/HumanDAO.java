package db;

import human.Human;

import java.io.*;
import java.text.*;
import java.util.ArrayList;
import java.util.Date;

public class HumanDAO {
    private File file;

    public HumanDAO(File file) {
        this.file = file;
    }

    public void write(Human human) throws IOException {
        validate(human);

        OutputStream out = new FileOutputStream(file, true);
        DataOutputStream writer = new DataOutputStream(out);
        try {
            String name = padString(human.getName(), 50);
            writer.writeBytes(name);

            String surName = padString(human.getSurName(), 50);
            writer.writeBytes(surName);

            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
            String date = formatter.format(human.getDate());
            writer.writeBytes(date);

            String position = padString(human.getPosition(), 100);
            writer.writeBytes(position);

            writer.writeDouble(human.getSalary());

            byte delete = 0;
            writer.writeByte(delete);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.close();
            out.close();
        }
    }

    public ArrayList<Human> read() throws IOException {
        ArrayList<Human> humans = new ArrayList<Human>();

        RandomAccessFile in = new RandomAccessFile(file, "r");
        try {
            byte[] buffNameOrSurName = new byte[50];
            byte[] buffDate = new byte[8];
            byte[] buffPosition = new byte[100];
            int seek = 0;
            do {
                in.seek(seek);
                in.read(buffNameOrSurName, 0, buffNameOrSurName.length);
                String name = new String(buffNameOrSurName, "UTF-8").trim();

                in.read(buffNameOrSurName, 0, buffNameOrSurName.length);
                String surName = new String(buffNameOrSurName, "UTF-8").trim();

                in.read(buffDate, 0, buffDate.length);
                String strDate = new String(buffDate, "UTF-8").trim();
                Date date = parseToDate(strDate);

                in.read(buffPosition, 0, buffPosition.length);
                String position = new String(buffPosition, "UTF-8").trim();

                double salary = in.readDouble();

                byte delete = in.readByte();

                Human human = new Human(name, surName, date, position, salary);
                humans.add(human);

                seek += 217;
            }
            while (seek < in.length());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            in.close();
        }
        return humans;
    }

    public void validate(Human human) throws IOException {
        validateString(human.getName(), 50, "Имя");
        validateString(human.getSurName(), 50, "Фамилия");
        validateString(human.getPosition(), 100, "Должность");
    }

    public void validateString(String str, int max, String name) throws IOException {
        byte[] bytes = str.getBytes();
        if (bytes.length > max) {
            throw new IOException(String.format("Неправильная длина поля \"%s\": %d байт. Максимальное значение %d байт",
                    name, bytes.length, max));
        }
    }

    public String padString(String str, int leng) {
        for (int i = str.length(); i < leng; i++)
            str += " ";
        return str;
    }

    public Date parseToDate(String str){
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

}

package db;

import human.Human;

import java.io.*;
import java.text.*;

public class HumanDAO {
    private File file;

    public HumanDAO(File file) {
        this.file = file;
    }

    public void write(Human human) throws IOException {
        validate(human);

        try (OutputStream out = new FileOutputStream(file, true);
             DataOutputStream writer = new DataOutputStream(out)
        ) {
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

                writer.writeInt(0);

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                writer.close();
                out.close();
            }
        }
    }

    public void read() throws IOException {
        try (RandomAccessFile in = new RandomAccessFile(file, "r");
        ) {
            try {
                byte[] buff = new byte[50];
                byte[] buffDate = new byte[8];
                int read = 0;
                int seek = 0;
                do {
                    in.seek(seek);
                    read = in.read(buff, 0, buff.length);
                    System.out.println(new String(buff, "UTF-8").trim());

                    read = in.read(buff, 0, buff.length);
                    System.out.println(new String(buff, "UTF-8").trim());

                    read = in.read(buffDate, 0, buffDate.length);
                    System.out.println(new String(buffDate, "UTF-8").trim());

                    read = in.read(buff, 0, buff.length);
                    System.out.print(new String(buff, "UTF-8").trim());
                    read = in.read(buff, 0, buff.length);
                    System.out.println(new String(buff, "UTF-8").trim());

                    double salary = in.readDouble();
                    System.out.println(salary);

                    int delete = in.readInt();
                    System.out.println(delete);
                    seek += 220;
                }
                while (read > 0 && seek < in.length());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                in.close();
            }
        }
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


}

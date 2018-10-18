package task_2_5_1;

import java.io.*;
import java.nio.file.Files;

public class Main {

    public static void main(String[] args) {
        String sourcename = "/Users/yulia/Documents/test.txt";
        File file = new File(sourcename);
        if (file.exists()) {
            String backupname = "/Users/yulia/Documents/test1.txt";
            boolean copied = false;
            try (OutputStream backup = new FileOutputStream(backupname)) {
                Files.copy(file.toPath(), backup);
                copied = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (copied) {
                file.delete();
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try (
                    InputStream backupInput = new FileInputStream(backupname);
                    OutputStream dest = new FileOutputStream(sourcename);
            ) {
                byte[] buff = new byte[1024];
                int read = 0;
                do {
                    read = backupInput.read(buff, 0, 1024);
                    String str = new String(buff, "UTF-8");
                    if (read > 0) {
                        str = str.replaceAll("Hello", "1234");
                        System.arraycopy(str.getBytes(), 0, buff, 0, str.length());
                        dest.write(buff, 0, buff.length);
                    }

                }
                while (read > 0);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                new File(backupname).delete();
            }
        }
    }
}

package rectangle;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int width;
        int height;
        for (; ; ) {
            width = enterWidth();
            height = enterHeight();
            if (checkSize(width, height))
                break;
        }
        Rectangle rectangle = new Rectangle(width, height);
        rectangle.draw();
    }

    public static int enterWidth() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter width:");
        int width = scanner.nextInt();
        return width;
    }

    public static int enterHeight() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter height:");
        int height = scanner.nextInt();
        return height;
    }

    public static boolean checkSize(int width, int height) {
        if (width > 0 && height > 0)
            return true;
        else {
            System.out.println("Error: you entered a wrong size!\nTry again:");
            return false;
        }
    }
}

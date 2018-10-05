package Figure;

public class Main {

    public static void main(String[] args) {

        Figure[] figures = {
                new Triangle(3, 4, 5), new Rectangle(2, 4), new Circle(3)
        };

        for (Figure figure : figures) {
            System.out.println("Square = " + figure.square());
        }
    }
}

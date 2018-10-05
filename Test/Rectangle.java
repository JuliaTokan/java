package Test;

public class Rectangle {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void draw() {
        Symbol horigontSymvol = new Symbol('═');
        Symbol verticalSymvol = new Symbol('║');
        Symbol upperLeftCorner = new Symbol('╔');
        Symbol upperRightCorner = new Symbol('╗');
        Symbol bottomLeftCorner = new Symbol('╚');
        Symbol bottomRightCorner = new Symbol('╝');

        final int cheight = height;

        for (int row = 0; row <= cheight; row++) {
            for (int colmn = 0; colmn <= width; colmn++) {
                switch (row) {
                    case 0:
                        if (colmn == 0)
                            upperLeftCorner.draw();
                        else if (colmn == width)
                            upperRightCorner.draw();
                        else horigontSymvol.draw();
                        break;
                    case cheight:
                        if (colmn == 0)
                            bottomLeftCorner.draw();
                        else if (colmn == width)
                            bottomRightCorner.draw();
                        else horigontSymvol.draw();
                        break;
                    default:
                        if (colmn == 0 || colmn == width)
                            verticalSymvol.draw();
                        else System.out.print(' ');
                        break;
                }

            }
            System.out.println();
        }
    }
}

package figure;

public class Triangle extends Figure {
    private double firstSide;
    private double secondSide;
    private double thirdSide;

    public Triangle(double firstSide, double secondSide, double thirdSide) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.thirdSide = thirdSide;
    }

    @Override
    public double square() {
        double halfPerimeter = perimeter() / 2;
        double square = Math.sqrt(halfPerimeter *
                (halfPerimeter - firstSide) *
                (halfPerimeter - secondSide) *
                (halfPerimeter - thirdSide));
        return square;
    }

    public double perimeter() {
        return firstSide + secondSide + thirdSide;
    }
}

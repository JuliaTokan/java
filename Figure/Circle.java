package Figure;

public class Circle extends Figure {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double square() {
        double square = Math.PI * Math.pow(radius, 2);
        return square;
    }
}

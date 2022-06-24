package ss7_abstractclass_interface.bai_tap;
public class Square extends Shape {
    private double side;

    public Square() {
    }

    public Square(double side) {
        this.side = side;
    }

    public Square(double side, String color, boolean filled) {
        super(color,filled);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public String toString() {
        return "A Square with side="
                + getSide()
                + ", which is a subclass of "
                + super.toString()
                + ", Area=" +
                + getArea();
    }

    double getArea() {
        return side * side;
    }

    public Square(String color, boolean filled) {
        super(color, filled);
    }

    public void resize(double percent) {
        this.side *= (percent / 200);
    }
}
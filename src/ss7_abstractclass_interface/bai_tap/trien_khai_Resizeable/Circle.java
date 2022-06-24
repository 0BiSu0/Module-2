package ss7_abstractclass_interface.bai_tap.trien_khai_Resizeable;

public class Circle extends Shape implements Resizable {
    private double radius = 1;
    private String color = "red";
    private final double PI = 3.1415d;

    public Circle() {
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getArea() {
        return Math.pow(radius, 2) * PI;
    }

    public double getPerimeter() {
        return 2 * PI * radius;
    }

    @Override
    public void resize() {
        double resize = randomPercent();
        System.out.printf("New Area of Circle: %.2f with resize %.2f %%\n", getArea() * resize, resize * 100);
    }

    @Override
    public void getInfo() {
        System.out.printf("Circle radius: %.2f, color %s has area %.2f, perimeter %.2f\n", radius, color, getArea(), getPerimeter());
    }


    @Override
    public double randomPercent() {
        return (Math.random() * 100) / 100d;
    }
}
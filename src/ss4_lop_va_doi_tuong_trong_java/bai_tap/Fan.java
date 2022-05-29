package ss4_lop_va_doi_tuong_trong_java.bai_tap;

public class Fan {
    private final int SLOW = 4;
    private final int MEDIUM = 7;
    private final int FAST = 9;
    private int speed = SLOW;
    private boolean isOn = false;
    private double radius = 2;
    private String color = "blue";

    public void setMaxSpeed() {
        speed = FAST;
    }

    public void setMediumSpeed() {
        this.speed = this.MEDIUM;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return this.isOn ? String.format("Speed: %d, Color: %s, Radius: %.1f. Fan is On", speed, color, radius) : String.format("Color: %s, Radius: %.1f. Fan is Off", color, radius);
    }
}
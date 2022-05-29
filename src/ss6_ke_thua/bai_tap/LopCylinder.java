package ss6_ke_thua.bai_tap;

public class LopCylinder extends LopCircle{
    double height;
    LopCylinder (){

    }
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    LopCylinder (double height){
        this.height=height;
    }
    LopCylinder (double height,double radius, String color){
        this.height=height;
        this.radius = radius;
        this.color = color;
    }
    public double Volume(){
        return super.PI*getRadius()*getRadius()*height;
    }

    @Override
    public String toString() {
        return "A Cylinder with height = "+getHeight()+" and Volume = "+Volume()+",which is a subclass of "
                + super.toString();
    }
}
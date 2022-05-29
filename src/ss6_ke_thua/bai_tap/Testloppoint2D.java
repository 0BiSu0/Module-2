package ss6_ke_thua.bai_tap;

public class Testloppoint2D{
    public static void main(String[] args) {
        Loppoint2D point1 = new Loppoint2D(3,5);
        for (int i = 0 ; i < point1.getXY().length;i++){
            System.out.println(point1.getXY()[i]);
        }
        System.out.println(point1);
    }
}
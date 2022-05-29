package ss4_lop_va_doi_tuong_trong_java.bai_tap;
import java.util.Scanner;
public class TestQuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap a: ");
        double a = scanner.nextDouble();
        System.out.println("Nhap b: ");
        double b = scanner.nextDouble();
        System.out.println("Nhap c: ");
        double c = scanner.nextDouble();
        XaydungQuadraticEquation pt1 = new XaydungQuadraticEquation(a,b,c);
        if (pt1.getDiscriminant()==0){
            System.out.print("Phuong trinh co 1 nghiem: \n"+pt1.getRoot1());
        }else if (pt1.getDiscriminant()>=0){
            System.out.print("Phuong trinh co 2 nghiem: \n"+pt1.getRoot1()+"\n"+pt1.getRoot2());
        }else {
            System.out.println("The equation has no roots");
        }
    }
}
package ss1_Introduction_java.IntroductionJava.thuc_hanh;

import java.text.DecimalFormat;
import java.util.Scanner;

public class FirstDegreeEquation {
    public static void main(String[] args) {
        int aNumber, bNumber;
        double test;
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Number a: ");
        aNumber = scanner.nextInt();
        System.out.println("Enter Number b");
        bNumber = scanner.nextInt();
        System.out.println("The equation you just entered is: " + aNumber + "x +" + bNumber + " = 0." );
        if(aNumber == 0){
            if (bNumber == 0){
                System.out.println("This equation has infinitely many solutions");
            }else {
                System.out.println("The equation has no solution");
            }
        }else {
            test = (double) - bNumber / aNumber;
            System.out.println("Equation has solution x =" + decimalFormat.format(test) + ".");
        }

    }
}

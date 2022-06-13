package ss2_Vong_lap_trong_java.thuc_hanh;

import java.util.Scanner;

public class Ungdungtinhtienlaichovay {
    public static void main(String[] args) {
        double money = 0;
        int month = 1;
        double interset_rate = 1.0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter investment amount: ");
        money = sc.nextDouble();
        System.out.println("Enter Number of months: ");
        month = sc.nextInt();
        System.out.println("Enter annual interest rate in percentage: ");
        interset_rate = sc.nextDouble();
        double total_interest = 0;
        for (int i = 0; i < month; i++){
            total_interest = money * (interset_rate/100/12)*3;

        }
        System.out.println("Total of interest: " + total_interest);
    }
}

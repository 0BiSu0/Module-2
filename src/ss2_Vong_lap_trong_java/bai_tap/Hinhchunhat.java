package ss2_Vong_lap_trong_java.bai_tap;

import java.util.Scanner;

public class Hinhchunhat {
    public static void main(String[] args) {
        int height;
        int wight;
        int i;
        Scanner sc = new Scanner(System.in);
        System.out.println("height = ");
        height = sc.nextInt();
        System.out.println("width = ");
        wight = sc.nextInt();
        for(i = 1; i <= height; i++){
            for(int j = 1; j <= wight; j++){
                System.out.println("* ");
            }
            System.out.println(" ");
        }
        sc.close();
    }
}

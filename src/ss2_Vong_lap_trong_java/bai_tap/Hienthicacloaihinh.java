package ss2_Vong_lap_trong_java.bai_tap;
import java.util.Scanner;
public class Hienthicacloaihinh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int height;
        System.out.println("\n\nNhập vào chiều cao của tam giác: ");
        height = sc.nextInt();
        for (int i = 1; i <= height; i++){
            for (int j = 1; j <= i; j++){
                System.out.println("* ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}

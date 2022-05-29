package ss1_Introduction_java.IntroductionJava.bai_tap.bai_tap;
import java.util.Scanner;
public class Ungdungchuyendoitiente {
    public static void main(String[] args) {
        double vnd = 23000;
        double usd;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your monney VND: ");
        usd = sc.nextDouble();
        double quydoi = usd * 23000;
        System.out.print("VND value: " + quydoi);
    }
}

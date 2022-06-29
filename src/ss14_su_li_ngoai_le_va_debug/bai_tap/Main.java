package ss14_su_li_ngoai_le_va_debug.bai_tap;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TriangleEdgesCheck check = new TriangleEdgesCheck();
        try {
            System.out.println("Enter the first edge: ");
            int a = sc.nextInt();
            System.out.println("Enter the second edge: ");
            int b = sc.nextInt();
            System.out.println("Enter the third edge: ");
            int c = sc.nextInt();
            try {
                check.checkTriangleEdges(a, b, c);
            } catch (TriangleEdgesException ex) {
                System.out.println(ex.getMessage());
            }
            } catch (Exception e) {
                System.out.println("Wrong Format!!!");
            }
            sc.close();
        }
    }


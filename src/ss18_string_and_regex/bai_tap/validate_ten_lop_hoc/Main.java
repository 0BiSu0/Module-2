package ss18_string_and_regex.bai_tap.validate_ten_lop_hoc;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ClassCheck classCheck = new ClassCheck();
        do {
            System.out.println("Nhập vào tên lớp: ");
            String str = sc.nextLine();
            try {
                classCheck.checkClass(str);
                break;
            }catch ( ClassException ex){
                System.out.println(ex.getMessage());
            }
        }while (true);
    }

}

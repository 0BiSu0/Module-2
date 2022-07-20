package ss18_string_and_regex.bai_tap.validate_so_dien_thoai;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        PhoneCheck phoneCheck = new PhoneCheck();
       do {
           System.out.println("Nhập vào số điện thoại: ");
           String str = sc.nextLine();
           try {
               phoneCheck.checkPhone(str);
               break;
           }catch (PhoneException ex){
               System.out.println(ex.getMessage());
           }
       }while (true);
    }
}

package luyen_tap.bai_tap_2;
import java.util.Scanner;
import static java.lang.Integer.parseInt;
public class Main {
    private static  PhoneManager phoneManager = new PhoneManager();

    public static void main(String[] args) {
        while (true) {
            System.out.print("1.Add new Phone\n2.Delete Phone By ID\n3.Show ALL List Phone\n4.Find by Name\n5.Quit\n");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Your choice: ");
            int choice1 = parseInt(scanner.nextLine());
            switch (choice1) {
                case 1:
                System.out.println("1. ChinhHang");
                System.out.println("2. XachTay");
                int choice2 = parseInt(scanner.nextLine());

                    System.out.print("ID: ");
                    int id = parseInt(scanner.nextLine());
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Price: ");
                    int price = parseInt(scanner.nextLine());
                    System.out.print("Producer: ");
                    String producer = scanner.nextLine();
                if(choice2 == 1){
                    System.out.print("Time: ");
                    int time = parseInt(scanner.nextLine());
                    System.out.print("Code: ");
                    String code = scanner.nextLine();
                    Phone ChinhHang = new ChinhHang(id, name, price, producer, time, code);
                    phoneManager.add(ChinhHang);
                }
                else {
                    System.out.print("Country: ");
                    String country = (scanner.nextLine());
                    System.out.print("Status: ");
                    String status = scanner.nextLine();
                    Phone XachTay = new XachTay(id, name, price, producer, country, status);
                    phoneManager.add(XachTay);
                }

                    System.out.println("Created successfully");
                    break;
                case 2:
                    phoneManager.showAllList();
                    System.out.println("Enter ID to Delete:");
                    int ID = parseInt(scanner.nextLine());
                    phoneManager.remove(ID);
                    System.out.println("Delete sucessfully!!!");
                    break;
                case 3: {

                    phoneManager.showAllList();
                }
                break;
                case 4:
                    System.out.println("Enter Name to Search: ");
                    String n = scanner.nextLine();
                    Phone phone = phoneManager.searchProductByName(n);
                    if (phone != null) {
                        System.out.println(phone);
                    }else {
                        System.out.println("Not Found!!!");
                    }
                    break;
            }




        }
    }
}


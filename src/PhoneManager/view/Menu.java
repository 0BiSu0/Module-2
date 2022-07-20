package PhoneManager.view;
import PhoneManager.Model.AuthenticPhonee;
import PhoneManager.Model.HandPhone;
import PhoneManager.Model.Phone;
import PhoneManager.Valid.Valid;
import PhoneManager.Exception.NotFoundException;
import PhoneManager.Service.PhoneService;
import java.util.Scanner;
import java.util.List;
public class Menu {
    private static  Scanner scanner = new Scanner(System.in);
    private static  PhoneService phoneService = new PhoneService();

    public static void main(String[] args) {
        while (true) {
            System.out.println("------Menu------");
            System.out.println("1. Create New");
            System.out.println("2. Display");
            System.out.println("3. Delete");
            System.out.println("4. Search");
            System.out.println("5. Exit");
            int choice = getChoice();
            switch (choice) {
                case 1:
                    create();
                    break;
                case 2:
                    display();
                    break;
                case 3:
                    delete();
                    break;
                case 4:
                    search();
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }

    private static void create() {
        System.out.println("1.AuthenticPhone\n2.HandPhone");
        int choice = getChoice();
        String name = "";
        do {
            System.out.print("Input name:");
            name = scanner.nextLine();
        } while (!Valid.checkName(name));

        String price = "";
        do {
            System.out.println("Price:");
            price = scanner.nextLine();
        } while (!Valid.isNumber(price));
        String manufacturer = inputWithEmpty("Enter Manufacturer:");
        PhoneManager.Model.Phone phone;
        if (choice == 1) {
            int granteeByYear = Integer.parseInt(inputWithEmpty("Grantee by Year"));
            String code = inputWithEmpty("Grantee By Code");
            phone = new AuthenticPhonee(0, name, Double.parseDouble(price), manufacturer, granteeByYear, code);
        } else {
            String country = inputWithEmpty("Enter Country: ");
            String status = inputWithEmpty("Enter Status: ");
            phone = new HandPhone(0, name, Double.parseDouble(price),manufacturer, country, status);
        }
        phoneService.create(phone);
        System.out.println("Created SuccessFully!!!");
    }

    private static void display() {
        List<Phone> phones = phoneService.findAll();

        for (int i = 0; i < phones.size(); i++) {
            System.out.println(phones.get(i));
        }
    }
    private static void delete() {
        display();
        boolean tmp = false;
        do {
            System.out.print(tmp ? "Enter id to delete again: " : "Enter id to Delete: ");
            int id = Integer.parseInt(scanner.nextLine());
            try {
                phoneService.delete(id);
                System.out.println("Delete successfully!!!");
                tmp = false;
            } catch (NotFoundException e) {
                System.out.println(e.getMessage());
                tmp = true;
            }
        } while (tmp);
    }

    private static void search() {
        System.out.println("Input name to search: ");
        String name = scanner.nextLine();
        List<Phone> phones = phoneService.search(name);
        if (phones.size() > 0) {
            for (int i = 0; i < phones.size(); i++) {
                System.out.println(phones.get(i));
            }
        } else {
            System.out.println("Empty list");
        }
    }

    private static int getChoice() {
        System.out.println("Enter your choice: ");
        return Integer.parseInt(scanner.nextLine());
    }

    private static String inputWithEmpty(String field) {
        String val = "0";
        do {
            System.out.println(val.isEmpty() ? "Invalid format. InPut again: " : field + ":");
            val = scanner.nextLine();
        } while (val.trim().isEmpty());
        return val;
    }
}


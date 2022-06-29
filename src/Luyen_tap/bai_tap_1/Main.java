package Luyen_tap.bai_tap_1;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {
        Luyen_tap.bai_tap_1.ProductManager ProductManager = new ProductManager();
        loop:
        while (true) {
            System.out.print("1.Add new\n2.Delete By ID\n3.Show ALL List\n4.Find by Name\n5.Quit\n");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Your choice: ");
            String choice = (scanner.nextLine());
            switch (choice) {
                case "1": {
                    System.out.print("ID: ");
                    int id = parseInt(scanner.nextLine());
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Price: ");
                    int price = parseInt(scanner.nextLine());
                    System.out.print("Producer: ");
                    String producer = scanner.nextLine();
                    Product product = new Product(id, name, price, producer);
                    ProductManager.add(product);
                }
                break;
                case "2": {
                    System.out.println("ID want delete: ");
                    int id = parseInt(scanner.nextLine());
                    ProductManager.remove(id);
                }
                break;
                case "3": {
                    ProductManager.showAllList();
                }
                break;
                case "4": {
                    System.out.print("Name want to check: ");
                    String name = scanner.nextLine();
                    if ((ProductManager.searchProductByName(name) == null)) {
                        System.out.printf("List not have another have name %s\n", name);
                    } else {
                        System.out.println(ProductManager.searchProductByName(name).toString());
                    }
                }
                break;
                default: {
                    System.out.println("Good Bye!!!");
                    break loop;
                }
            }
        }
    }
}

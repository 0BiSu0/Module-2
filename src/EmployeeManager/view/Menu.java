/*
package EmployeeManager.view;
import EmployeeManager.Model.Danhsach;
import EmployeeManager.Exception.NotFoundException;
import EmployeeManager.Service.DanhsachService;
import EmployeeManager.Valid.Valid;
import java.util.Scanner;
import java.util.List;
public class Menu {
    private static  Scanner scanner = new Scanner(System.in);
    private static DanhsachService danhsachService = new DanhsachService();
    public static void main(String[] args) {
        while (true) {
            System.out.println("------CHUONG TRINH QUAN LY DANH BA------");
            System.out.println("1. Them moi danh sach");
            System.out.println("2. Xem danh sach ");
            System.out.println("3. Cap nhat danh sach ");
            System.out.println("4. Xoa ");
            System.out.println("5. Tim kiem ");
            System.out.println("6. Doc tu file ");
            System.out.println("7. Them vao file ");
            System.out.println("8. Exit");
            int choice = getChoice();
            switch (choice) {
                case 1:
                    create();
                    break;
                case 2:
                    display();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    search();
                    break;
                case 6:
                    readfile();
                    break;
                case 7:
                    addtofile();
                    break;
                case 8:
                    System.exit(0);
            }
        }
    }
    private static void search(){
        System.out.println("Nhap ten can tim: ");
        String name = scanner.nextLine();
        List<Danhsach> danhsaches = danhsachService.search(name);
        if (danhsaches.size() > 0) {
            for (int i = 0; i < danhsaches.size(); i++) {
                System.out.println(danhsaches.get(i));
            }
        } else {
            System.out.println("Empty list!!!");
        }
    }
    private  static  void  addtofile(){
    */
/*    danhsaches.sort(Comparator.comparing(Person::getFullName));
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            bufferedWriter.write(Person.getAllProps);
            bufferedWriter.newLine();
            for (Person person : personList) {
                bufferedWriter.write(person.getData());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("File NOT FOUND");
        }
        System.out.println("Saving...");
    }*//*

    private static void readfile() {
    }

    private static void update(){
    private static void create() {
        String name = "";
        do {
            System.out.print("Nhap ten:");
            name = scanner.nextLine();
        } while (!EmployeeManager.Valid.Valid.checkName(name));

        String age ;
        do {
            System.out.println("Nhap tuoi:");
            age = scanner.nextLine();
        } while (!Valid.isNumber(age));
        String sex;
        do {
            System.out.println("Nhap vao gioi tinh: ");
            sex = scanner.nextLine();
        }while (!Valid.isNumber(sex));
        String address = "";
       do {
           System.out.println("Nhap dia chi:");
           address = scanner.nextLine();
       }while (!Valid.isNumber(address));
        String email;
        do {
            System.out.println("Nhap vao email:");
            email = scanner.nextLine();
        }while (!Valid.isNumber(email));

        System.out.println("Them moi Thanh cong!!!");
    }

    private static void display() {
        List<Danhsach> danhsaches = danhsachService.findAll();
        for (int i = 0; i < danhsaches.size(); i++) {
            System.out.println(danhsaches.get(i));
        }
    }
    private static void delete() {
        display();
        boolean tmp = false;
        do {
            System.out.print(tmp ? "Enter id to delete again: " : "Enter id to Delete: ");
            int id = Integer.parseInt(scanner.nextLine());
            try {
                danhsachService.delete(id);
                System.out.println("Xoa thanh cong!!!");
                tmp = false;
            } catch (NotFoundException e) {
                System.out.println(e.getMessage());
                tmp = true;
            }
        } while (tmp);
    }

    private static int getChoice() {
        System.out.println("Nhap vao lua chon cua ban: ");
        return Integer.parseInt(scanner.nextLine());
    }
    private static String inputWithEmpty(String field) {
        String val = "0";
        do {
            System.out.println(val.isEmpty() ? "Dinh dang khong dung!!!. Hay Nhap lai: " : field + ":");
            val = scanner.nextLine();
        } while (val.trim().isEmpty());
        return val;
    }
}
*/

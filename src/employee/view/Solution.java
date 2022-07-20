package employee.view;

import employee.controller.PersonController;
import employee.models.Employee;
import employee.models.Student;
import employee.utils.enum_choice.EnumChoice;
import employee.utils.enum_choice.PersonChoice;

import java.util.List;
import java.util.Scanner;

public class Solution {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        loop:
        while (true) {
            EnumChoice option = selectMain();
            switch (option) {
                case ADD_NEW: {
                    displayAddNew();
                    break;
                }
                case DELETE: {
                    displayDelete();
                    break;
                }
                case DISPLAY: {
                    displayListPerson();
                    break;
                }
                case QUIT: {
                    break loop;
                }
            }
        }
    }

    private static void displayListPerson() {
        PersonController.displayPersonList();
    }

    private static void displayDelete() {
        String idPerson = getIdPersonExists();

        String choice = MenuDisplay.getStringValue(String.format("Search %s\nYour want delete??? Yes or No ",
                PersonController.searchPersonById(idPerson).toString()));

        if (choice.equalsIgnoreCase("yes")) {
            PersonController.deletePersonById(idPerson);
            System.out.println("Delete Complete!!!");
            PersonController.saveCSV();
            displayListPerson();
            return;
        }
        System.out.println("Not delete!!!");
    }

    private static void displayAddNew() {
        PersonChoice option = selectPersonAddNew();
        switch (option) {
            case EMPLOYEE: {
                List<String> list = MenuDisplay.collectDataFromUserInput(Employee.getProps, "NV");
                PersonController.addNewPerson(new Employee(list));
                PersonController.saveCSV();
                break;
            }
            case STUDENT: {
                List<String> list = MenuDisplay.collectDataFromUserInput(Student.getProps, "HV");
                PersonController.addNewPerson(new Student(list));
                PersonController.saveCSV();
                break;
            }
            case BACK_MAIN: {
                break;
            }
        }
    }

    public static String getIdPersonExists(){
        String idPerson;
        while (true) {
            displayListPerson();
            idPerson = MenuDisplay.getStringValue("Id want delete: ");

            if (PersonController.isNotExistPersonById(idPerson)) {
                System.out.println("List not exists id " + idPerson);
                continue;
            }
            return idPerson;
        }
    }
    private static PersonChoice selectPersonAddNew() {
        return DisplayEnumChoice.selectMenuOption(scanner, PersonChoice.class);
    }

    private static EnumChoice selectMain() {
        return DisplayEnumChoice.selectMenuOption(scanner, EnumChoice.class);
    }
}

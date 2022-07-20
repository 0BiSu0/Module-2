package employee.controller;

import employee.models.Employee;
import employee.models.Person;
import employee.models.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PersonController {
    static List<Person> personList = new ArrayList<>();

    static String empty = "empty";

    static final String COMMA_DELIMITER = ",";

    static String fileName = "src\\employee\\data\\Person.csv";


    static {
        readAndUpdateList();
    }





    public static void addNewPerson(Person person) {
        if (isNotExistByIdPerson(person)) {
            personList.add(person);
        }
    }




    public static boolean isNotExistByIdPerson(Person person) {
        return personList.stream().noneMatch(x -> x.getIdPerson().equalsIgnoreCase(person.getIdPerson()));
    }

    public static boolean isExistByIdPerson(String idPerson) {
        return personList.stream().anyMatch(x -> x.getIdPerson().equalsIgnoreCase(idPerson));
    }


    public static void displayPersonList() {
        if (personList.isEmpty()) {
            System.out.println("Empty! Update please!");
            return;
        }
        personList.sort(Comparator.comparing(Person::getFullName));
        personList.forEach(x -> System.out.println(x.toString()));
    }






    public static void deletePersonById(String idAccount) {
        personList.remove(searchPersonById(idAccount));
    }





    public static Person searchPersonById(String id) {
        return personList.stream().filter(x -> x.getIdPerson().equalsIgnoreCase(id))
                .findFirst().orElse(null);
    }






    public static boolean isNotExistPersonById(String id) {
        return personList.stream().noneMatch(x -> x.getIdPerson().equalsIgnoreCase(id));
    }




    public static void saveCSV() {
        personList.sort(Comparator.comparing(Person::getFullName));
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
    }


    public static void readAndUpdateList() {
        File file = new File(fileName);
        if (file.length() == 0) return;
        boolean flag = true;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                if (flag) {
                    flag = false;
                    continue;
                }
                String[] currentArray = line.split(COMMA_DELIMITER);
                String check = currentArray[currentArray.length - 1];
                List<String> tempList = new ArrayList<>();
                for (String element : currentArray) {
                    if (element.equalsIgnoreCase(empty)) {
                        continue;
                    }

                    tempList.add(element);
                }

                if (!check.equals("empty")) {
                    addNewPerson(new Student(tempList));
                } else {
                    addNewPerson(new Employee(tempList));
                }
            }
        } catch (IOException e) {
            System.out.println("File NOT FOUND");
        }
        personList.sort(Comparator.comparing(Person::getFullName));
    }
}
